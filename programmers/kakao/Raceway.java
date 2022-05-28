package kakao;

/* 경주로 건설

오랜만에 1 Try로 통과했다..! 억지스럽게 했는데 효율성 컷이 없었던 것 같다.
남들 Queue로 bfs를 사용할 떄 나는 dfs를 재귀로 돌려서 처리 시간이 너무 튀었다. ㅠ

그리고, 4 방향 처리 시 기본 배열(dx, dy) 구현하자.

그래도 객체랑 enum을 알고리즘 테스트에 적용할 수 있게 되어서 기쁘다.
 */

import java.util.Arrays;

public class Raceway {
    public int solution(int[][] board) {
        int length = board.length;
        int[][] costs = new int[length][length];
        for (int i = 0; i<length; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        dfs(board, costs, 0, 0, 0, Arrow.start);
        return costs[length-1][length-1];
    }

    public void dfs(int[][] board, int[][] costs, int x, int y, int curCost, Arrow arrow) {
        int length = board.length;

        costs[y][x] = curCost;

        int nextColCost = curCost + (arrow != Arrow.row ? 100 : 600);
        int nextRowCost = curCost + (arrow != Arrow.col ? 100 : 600);

        if(x + 1 < length && board[y][x+1] == 0 && costs[y][x+1] >= nextColCost) {
            dfs(board, costs, x+1, y, nextColCost, Arrow.col);
        }

        if(x - 1 >= 0 && board[y][x-1] == 0 && costs[y][x-1] >= nextColCost) {
            dfs(board, costs, x-1, y, nextColCost, Arrow.col);
        }

        if(y + 1 < length && board[y+1][x] == 0 && costs[y+1][x] >= nextRowCost) {
            dfs(board, costs, x, y+1, nextRowCost, Arrow.row);
        }

        if(y - 1 >= 0 && board[y-1][x] == 0 && costs[y-1][x] >= nextRowCost) {
            dfs(board, costs, x, y-1, nextRowCost, Arrow.row);
        }
    }

    enum Arrow {
        col, row, start
    }

    public static void main(String[] args) {
        Raceway raceway = new Raceway();
        int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(raceway.solution(board));
    }
}

/*public class Solution {
    public int solution(int[][] board) {
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
        int N = board.length;

        int[][][] cost = new int[N][N][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1});
        queue.add(new int[]{0, 0, 0, 3});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
                int c = cur[2] + (cur[3] == k ? 100 : 600);

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 1 || cost[ny][nx][k] <= c) continue;
                cost[ny][nx][k] = c;
                queue.add(new int[]{ny, nx, c, k});
            }
        }

        return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
    }
}*/
