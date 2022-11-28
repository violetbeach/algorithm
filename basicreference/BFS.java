import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
    static boolean[] visited = new boolean[graph.length];

    public void BFS(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n); // 시작 지점
        visited[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            // Custom 처리
            process();

            for (int y : graph[x]) {
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public void process() {

    }
}
