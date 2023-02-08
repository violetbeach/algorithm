package heap;

import java.util.*;
import java.io.*;

class SupplyWay
{
    static int N;
    static int min;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception
    {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            isVisited = new boolean[N][N];
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            bfs(0, 0);

            System.out.println("#" + (tc+1) + " "+min);
        } // tc end
    }

    static void bfs(int x, int y) {
        PriorityQueue<Pos> que = new PriorityQueue<>();

        que.add(new Pos(x, y, 0)); // 총 복구 시간은 아직 0이다.
        isVisited[x][y] = true; // 방문 처리

        while(!que.isEmpty()) {
            Pos p = que.poll();

            int curX = p.x;
            int curY = p.y;
            int curT = p.time;

            if(curX == N-1 && curY == N-1) { // 목적지에 도달했을 때 복구시간을 비교하여 최솟값을 구한다.
                min = min > curT ? curT : min;
            }

            for(int t=0; t<4; t++) {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(!isVisited[nx][ny]) {
                    int totalTime = curT + map[nx][ny]; // 탐색한 좌표에 있는 수(복구시간)을 더해 이 경로까지의 총 복구 시간을 구한다.
                    que.add(new Pos(nx, ny, totalTime)); // 그 시간과 새로운 좌표를 큐에 넣는다.
                    isVisited[nx][ny] = true; // 방문 처리
                }

            }

        }

    }

    static class Pos implements Comparable<Pos>{
        int x, y;
        int time; // 복구하는 데 든 시간

        Pos(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) { // 복구 시간이 작을 수록 우선순위가 높다.(오름차순 정렬 해야 함.)
            if(this.time < o.time) {
                return -1;
            } else if(this.time > o.time) {
                return 1;
            }
            return 0;
        }
    }
}