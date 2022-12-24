package skillcheck.level3;

/*
* 블록 이동하기
*
* 1. 2차원 배열은 Arrays.fill을 사용할 때 반복문 선언이 필요하다.
* 2. arr.clone()을 사용하면 2차원 배열 깊은 복사가 가능하다.
* 3. Arrays.toString()을 사용하면 배열 원소 전체 출력이 가능하다. (디버깅 용도)
* 4. dx, dy를 사용하면 조금 쉽게할 수 있었다.
*
* 7번 문제인데도 깔끔하게 잘 풀었다..! (7번인거 알고는 완전 뿌듯..!)
*
* 가장 중요. BFS와 DFS에 재귀를 사용하지 말자.
* 하지만, 배열이 클 수록 다른 사람들 로직보다 시간이 훨씬 오래걸렸는데, **bfs와 dfs**를 반드시 재귀로 호출하는 매우 안좋은 버릇 떄문이다..!
* BFS는 Queue로, DFS는 Stack으로 처리가 가능하다. 나는 늘 재귀를 돌렸고, 이번에도 재귀를 돌리다가 성능이 터졌다..!!
* 재귀를 써야하는 기준에 대해 파악한 후, 가능하면 Queue나 Stack으로 처리하자.
*
* bfs가 dfs보다 나았던 이유를 전혀 활용하지 않았음
* bfs는 조기 종료가 가능함 (찾으면 그것이 가장 빠른 방법이기 때문 - 같은 시간끼리 탐색하므로)
*   + 방문 여부로 바로 삭제 가능
*/

import java.util.Arrays;

public class MoveBlock {

    int[][] rowDP;
    int[][] colDP;
    int[][] globalBoard;

    public int solution(int[][] board) {
        int size = board.length;

        // 각 좌표는 우측 하단에 있는 날개를 기준으로 한다.
        rowDP = new int[size][size];
        colDP = new int[size][size];

        globalBoard = board.clone();

        for(int i = 0; i < size; i++) {
            Arrays.fill(rowDP[i], Integer.MAX_VALUE);
            Arrays.fill(colDP[i], Integer.MAX_VALUE);
        }

        colDP[0][1] = 0;

        // type = 0: 가로, type = 1: 세로
        int type = 0;

        bfs(size, 1, 0, 0, 0);

        int answer = Math.min(rowDP[size-1][size-1], colDP[size-1][size-1]);

        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

    void bfs(int size, int x, int y, int type, int value) {
        if(!isAvailable(size, x, y, type)) {
            return;
        }

        if(type == 0) {
            if(colDP[y][x] < value) {
                return;
            }
            colDP[y][x] = value;
        } else {
            if(rowDP[y][x] < value) {
                return;
            }
            rowDP[y][x] = value;
        }

        // 1. 가로 이동
        bfs(size, x+1, y, type, value+1);
        bfs(size, x-1, y, type, value+1);

        // 2. 세로 이동
        bfs(size, x, y+1, type, value+1);
        bfs(size, x, y-1, type, value+1);

        // 3. 회전
        if(type == 0) {
            if(isAvailable(size, x, y+1, 0)) {
                bfs(size, x, y+1, 1, value+1);
                bfs(size, x-1, y+1, 1, value+1);
            }
            if(isAvailable(size, x, y-1, 0)) {
                bfs(size, x, y, 1, value+1);
                bfs(size, x-1, y, 1, value+1);
            }
        }

        if(type == 1) {
            if(isAvailable(size, x+1, y, 1)) {
                bfs(size, x+1, y-1, 0, value+1);
                bfs(size, x+1, y, 0, value+1);
            }
            if(isAvailable(size, x-1, y, 1)) {
                bfs(size, x, y, 0, value+1);
                bfs(size, x, y-1, 0, value+1);
            }
        }

    }

    boolean isAvailable(int size, int x, int y, int type) {
        if(type == 0) {
            if(x - 1 < 0 || x >= size) {
                return false;
            }
            if(y < 0 || y >= size) {
                return false;
            }
            if(globalBoard[y][x] != 0 || globalBoard[y][x-1] != 0) {
                return false;
            }

        }

        if(type == 1) {
            if(x < 0 || x >= size) {
                return false;
            }
            if(y - 1 < 0 || y >= size) {
                return false;
            }
            if(globalBoard[y][x] != 0 || globalBoard[y-1][x] != 0) {
                return false;
            }
        }
        return true;
    }
}
