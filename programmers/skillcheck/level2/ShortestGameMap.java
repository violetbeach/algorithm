package skillcheck.level2;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
// BFS 써야함. DP + DFS쓰다가 하나 TC효율 날라감.
// 기본적으로 모든 가중치가 동일해서 간선의 수로 답을 도출할 때는 BFS 써야함.

// BFS가 가능한 문제에 DP + DFS를 쓰면 안되는 이유
// 1. DP는 모든 경로를 다 까야함.
// 2. Boolean배열이 아닌 int 배열을 써야함.
// 3. 조건이 더 많음
// 4. 초기 배열 Max로 설정해줘야함.
// 5. 재귀를 해야함 (이게 가장 큼) !!!

// 뭐 퍼포먼스가 평균적으로 2배이상 차이나고 그러진 않는듯 함. 그래도 BFS를 써야함.

public class ShortestGameMap {
	int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        return bfs(0, 0, n, m, visited, maps);
    }
    
    public int bfs(int x, int y, int n, int m, boolean[][] visited, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == n - 1 && node.y == m - 1) return node.cost;
            
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }
    
    public class Node {
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
