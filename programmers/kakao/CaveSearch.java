package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*  동굴 탐험
*
* 요구사항을 잘 읽자. 요구사항대로 자료구조를 구현하면 실마리가 잡히는 것 같다.
*
* 모든 노드를 순서대로 방문하면서,
*   선후관계가 있다면 해당 노드를 완벽히 방문하지 않고 표시만 해둔다.
*   모든 노드를 방문하면서 표시된 이후 노드가 없는 지 체크한다.
*
* 만약 한 노드당 여러개의 선후노드가 있거나 했다면 이러한 처리가 불가능했다.
* - 어떤 방을 방문하기 위해 반드시 먼저 방문해야 하는 방은 없거나 또는 1개입니다.
*   - 배열 사용 가능
*   - 충돌 걱정을 하지 않고 모든 노드를 방문하면서 동시에 선후 체크를 수행할 수 있다.
* - 먼저 방문해야 하는 방이면서 나중에 방문해야 하는 방은 없습니다.
*   - 나중에 방문할 방은 선후 관계 충족 여부를 반드시 O로 할 수 있음
*
* 빡구현(?)인데 너무 어렵다. (그런데 자세히 생각해보면 어렵지 않은 것 같기도 하다.)
* 그냥 BFS로 탐색하면서 선후구조가 충족이 안되었으면 보류해주고, 선이 처리될때 후를 후속처리해주면 된다.
*
* */

public class CaveSearch {
    private int size;
    private List<List<Integer>> graph;
    private int[] before;
    private int[] after;

    public boolean solution(int n, int[][] path, int[][] order) {
        init(n, path, order);
        return canSearchAllRooms();
    }

    private void init(int n, int[][] path, int[][] order) {
        size = n;
        graph = new ArrayList<>();
        before = new int[n];
        after = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] arr : path) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        for (int[] arr : order) {
            before[arr[1]] = arr[0];
            after[arr[0]] = arr[1];
        }
    }

    private boolean canSearchAllRooms() {
        int numOfRoomsVisited = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[size]; // 0 : 방문 X, 1 : 방문 but 선후관계 X, 2 : 방문
        if (before[0] == 0) {
            q.offer(0);
            visited[0] = 2;
        }
        while (!q.isEmpty()) {
            int curNode = q.poll();
            numOfRoomsVisited++;
            for (int nextNode : graph.get(curNode)) {
                if (visited[nextNode] == 2) {
                    continue;
                }
                if (visited[before[nextNode]] != 2) {
                    visited[nextNode] = 1;
                    continue;
                }
                q.offer(nextNode);
                visited[nextNode] = 2;
            }
            int saveNode = after[curNode];
            if (saveNode != 0 && visited[saveNode] == 1) {
                q.offer(saveNode);
                visited[saveNode] = 2;
            }
        }
        return numOfRoomsVisited == size;
    }
}
