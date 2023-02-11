package heap;

import java.util.*;
import java.io.*;

/*
* 문제를 잘못이해했음 (D가 누적되는 구조였음)
* 즉, ** D를 순차적으로 올리면서 ** 계속 큐에 작업을 넣는다.
*
* 그래서 cnt가 낮은걸로 우선순위 큐에 작업을 넣어주면 처리가 되었음
*
* */

public class MakeNumber {
    static class state implements Comparable<state>{
        int k;
        int cnt;
        state(int k, int cnt){
            this.k = k;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(state o) {
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            String[] line = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(line[i]);
            }
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<state> q = new PriorityQueue<>();
            q.add(new state(K, 0));
            int ans = 0;
            while(!q.isEmpty()) {
                state s = q.poll();

                if(s.k == 0) {
                    ans = s.cnt;
                    break;
                }

                for(int i=0; i<N; i++) {
                    if(s.k % A[i] == 0) {
                        q.add(new state(s.k/A[i], s.cnt));
                    }else {
                        q.add(new state(s.k/A[i], s.cnt + (s.k%A[i])));
                    }
                }
            }

            sb.append("#").append(tc).append(" ");
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}