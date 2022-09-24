package programmers.test2022.L4;


import java.util.ArrayList;
import java.util.List;

/*
* 클라이밍
*
* 가로부터 방문함녀 Visit 처리해도 됬었다.. ㅠㅠ!!
*
* 다익스트라 모르면 답 없다.. ㅠ (공부하자..!)
* 반복 훈련하자.
*
* */

public class Solution4 {

    class Hold {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Hold(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int colLength;
    int rowLength;

    public int[][] solution(String[] wall) {

        colLength = wall[0].length();
        rowLength = wall.length;
        int x = 0;
        int y = rowLength - 1;

        int[][] answer = new int[rowLength][colLength];

        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(wall[i].charAt(j) == '.' || wall[i].charAt(j) == 'X') {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        answer[y][x] = 1;

        List<Hold> list = new ArrayList<>();

        int distance = 1;
        while(true) {
            list.addAll(getPossibleHold(x, y, wall));
            if(list.size() > 0) {
                for(Hold hold : list) {
                    answer[hold.getY()][hold.getX()] = Math.min(distance, answer[hold.getY()][hold.getX()]);
                }
                distance++;
            }
            break; // TEMP
        }

        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(answer[i][j] == Integer.MAX_VALUE) {
                    answer[i][j] = -1;
                }
            }
        }

        return answer;
    }

    List<Hold> getPossibleHold(int x, int y, String[] wall) {
        int[] direct = {1, -1, 2, -2};

        List<Hold> holds = new ArrayList<>();

        for(int dx : direct) {
            if(x + dx + 1 < colLength && y - 1 < rowLength) {
                if(wall[y].charAt(x + dx + 1) == 'H') {
                    if(checkHorizontal(x, x + dx + 1, y, wall)) {
                        holds.add(new Hold(x + dx + 1, y));
                    }
                }
            }
        }

        if(y - 2 < rowLength) {
            if(wall[y - 2].charAt(x) == 'H') {
                if(wall[y-1].charAt(x) == '.') {
                    holds.add(new Hold(x, y - 2));
                }
            }
        }

        int[] dd = {-1, 1};
        for(int dl : dd) {
            if(x + dl < colLength && y - 1 < rowLength) {
                if(wall[y - 1].charAt(x + dl) == 'H') {
                    if(wall[y].charAt(x + dl) == '.' && wall[y - 1].charAt(x) == '.') {
                        holds.add(new Hold(x + dl, y - 1));
                    }
                }
            }
        }
        return holds;
    }

    boolean checkHorizontal(int x, int targetX, int y, String[] wall) {
        for (int i = x; i <= targetX; i++) {
            if(wall[y - 1].charAt(i) != '.') {
                return false;
            }
        }

        for(int i = x + 1; i <= targetX - 1; i++) {
            if(wall[y].charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

}