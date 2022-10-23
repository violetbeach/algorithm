package skillcheck.level3;

/*
* 카드 짝 맞추기
*
* 1x1에서 최단거리 구하는거면 바로 BFS가 떠올랐어야 함! (재귀가 아님..! BFS를 사용했어야 함!!)
*
* (6! * 2^6(한 종류에도 2개의 카드가 있음))
*
* 순열 사용을 잛 보자..! (어렵지만, 내 것으로 만들어야 한다!!)
* */


/* 아래 함수를 사용하면 BFS를 할 때 Index 검증을 더 편하게 구현할 수 있었다.
static boolean available(int x, int y) {
    return x < 0 || x > 3 || y < 0 || y > 3;
}
*/

import java.util.LinkedList;
import java.util.Queue;

public class PairCardSearch {

    static boolean[] isNum, visitedPermutation;
    static int size = 0;
    static int answer;
    static int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}}, 1, 0));
    }

    public static int solution(int[][] board, int r, int c) {
        answer = Integer.MAX_VALUE;
        isNum = new boolean[7];
        visitedPermutation = new boolean[7];

        //현재 카드 종류를 isNum에 체크해놓고 체크해 둔 숫자중에 순열로 뽑을 예정
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(board[i][j] == 0 || isNum[board[i][j]]) continue;
                isNum[board[i][j]] = true;
                size++;
            }
        }

        Permutation(0, new int[size], board, r, c);

        return answer;
    }

    public static void bfs(int[][] board, int[] arr, int sr, int sc) {
        Queue<Point> q = new LinkedList<>();
        // 최단거리 방문 배열
        boolean[][] visited = new boolean[4][4];
        // 현재 말판을 엔터 쳤는지 체크하는 배열
        boolean[][] boardVisited = new boolean[4][4];
        //최단 거리
        int cnt = 0;
        int answerCnt = 0;
        int idx = 0;
        boolean isSecond = false;

        q.add(new Point(sr, sc));
        visited[sr][sc] = true;

        while(!q.isEmpty()) {
            int len = q.size();

            for(int l=0; l<len; l++) {
                Point now = q.poll();

                if(board[now.x][now.y] == arr[idx] && !boardVisited[now.x][now.y]) {
                    //Enter 누적시켜주기
                    answerCnt++;
                    //지금까지 최소 이동회수 더해주기
                    answerCnt+=cnt;
                    //이동회수 초기화 -1인 이유는 밑에서 바로 +1을 해주면 0이 되기 때문
                    cnt = -1;
                    //이미 방문한 말판임을 체크하기
                    boardVisited[now.x][now.y] = true;
                    //큐 및 visited 비워주기(다시 최단거리로 이동하기 위해)
                    q.clear();
                    visited = new boolean[4][4];
                    //초기 시작점 현재 좌표로 설정
                    q.add(new Point(now.x, now.y));
                    visited[now.x][now.y] = true;

                    //만약 처음 도착한거라면
                    if(!isSecond) {
                        //다음엔 두번째임을 체크하기 위함
                        isSecond = true;
                    } else {
                        //다음은 새로운 첫번째 말판을 찾아야함을 체크
                        isSecond = false;
                        //다음 말 종류를 찾기위해 순열로 뽑은 배열의 index를 증가시켜줌
                        idx++;
                        //index가 길이보다 길거나 같다 > 즉 모두 다 찾았다.
                        if(idx >= arr.length) {
                            //현재까지 누적한 값의 최소값 찾아줌
                            answer = Math.min(answer, answerCnt);
                            return;
                        }
                    }
                    break;
                }

                //한칸 움직이기
                for(int i=0; i<4; i++) {
                    int nx = now.x + dist[i][0];
                    int ny = now.y + dist[i][1];

                    if(!isIn(nx, ny) || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }

                //Ctrl + 움직임
                for(int i=0; i<4; i++) {
                    int nx = now.x;
                    int ny = now.y;

                    //범위 끝이면 종료되는 while문
                    while(isIn(nx + dist[i][0], ny + dist[i][1])) {
                        nx += dist[i][0];
                        ny += dist[i][1];
                        //만약 엔터치지않은 말이 존재하면 거기에 멈춰짐
                        if(!boardVisited[nx][ny] && board[nx][ny] != 0) break;
                    }

                    if(!isIn(nx, ny) || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
            cnt++;
        }
    }

    public static boolean isIn(int x, int y) {
        return 0<=x && x<4 && 0<=y && y<4;
    }

    //순열로 현재 카드의 방문 순서를 정한다.
    public static void Permutation(int cnt, int[] arr, int[][] board, int r, int c) {
        if(size == cnt) {
            //정해진 방문 순서대로 bfs를 돌림
            bfs(board, arr, r, c);
            return;
        }

        for(int i=1; i<=6; i++) {
            if(!isNum[i] || visitedPermutation[i]) continue;
            visitedPermutation[i] = true;
            arr[cnt] = i;
            Permutation(cnt+1, arr, board, r, c);
            visitedPermutation[i] = false;
        }
    }

}
