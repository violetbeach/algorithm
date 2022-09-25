package skillcheck.level3;

import java.util.ArrayList;
import java.util.List;

/*
* 기둥과 보 설치
*
* 크으.. 정말 문제답고 정말 정말 좋은 문제다.
*
* 메서드 설계를 잘해서 재활용이 가능하게 만들어야 한다.
* (튼튼하게 설계하지 못하면 기존의 코드를 갈아 엎어야 하는 경우가 발생한다.) - 이런 문제 너무 좋다!!!
*
* delete 알고리즘을 작성하다 막혔는데, 그냥 완탐하면 됬었다.
*
* 문제가 재밌다. 열심히 풀어보자!
* */
public class ColumnsAndGirders {

    int size;
    int[][] building;

    static final int space = 0;
    static final int column = 1;
    static final int girder = 2;

    public int[][] solution(int n, int[][] build_frame) {
        size = n+1;

        building = new int[size][size];

        for(int[] work : build_frame) {
            building[work[1]][work[0]] = getResult(work[0], work[1], work[2], work[3]);
        }

        List<int[]> answer = new ArrayList<>();

        for(int i = 0; i < size; i++) {

            for(int j = 0; j< size; j++) {

                if(building[j][i] == column) {
                    answer.add(new int[]{i, j, 0});
                }

                if(building[j][i] == girder) {
                    answer.add(new int[]{i, j, 1});
                }

            }

        }

        int[][] arrayAnswer = new int[answer.size()][3];

        for(int i = 0; i < answer.size(); i++) {

            for(int j = 0; j < 3; j++) {
                arrayAnswer[i][j] = answer.get(i)[j];
            }
        }

        return arrayAnswer;
    }

    int getResult(int x, int y, int frame, int type) {

        if(type == 1) {
            if(frame == column - 1) return columnProcess(x, y);
            if(frame == girder - 1) return girderProcess(x, y);
        }

        return 0;
    }

    int columnProcess(int x, int y) {
        if(y == 0) return column;
        if(y - 1 >= 0 && building[y-1][x] == column - 1) return column;
        if(y - 1 >= 0) {
            if(building[y-1][x] == girder - 1) return column;
            if(x - 1 > 0 && building[y-1][x-1] == girder - 1) return column;
        }
        return building[y][x];
    }

    int girderProcess(int x, int y) {
        if(y - 1 >= 0) {
            if(building[y-1][x] == column - 1) return girder;
            if(x + 1 < size && building[y-1][x+1] == column - 1) return girder;
        }
        if(x - 1 >= 0) {
            if(building[y][x-1] == girder - 1) return girder;
        }
        if(x + 1 < size) {
            if(building[y][x+1] == girder - 1) return girder;
        }
        return building[y][x];
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        ColumnsAndGirders solution = new ColumnsAndGirders();
        int[][] result = solution.solution(n, build_frame);
        System.out.println(result);
    }

}
