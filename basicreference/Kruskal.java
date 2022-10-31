/*
* 크루스칼 알고리즘
*
* 유니온-파인드를 포함한다.
* (부모가 같은 노드끼리 합치면서 찾는 알고리즘) - 서로소 집합을 찾기 좋음
*
* 내 것으로 만들지 않으면 금방 잊어먹는다.
* */

public class Main {
    // 유니온
    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    // 파인드
    public static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    // 크루스칼
    public static void kruskal(int[][] graph, int[] parent) {
        int cost = 0;
        for(int i = 0; i < graph.length;i++) {
            // 시작지와 도착지의 부모가 같아야 사이클이 돈다는 뜻
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                cost += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }

        // 최소 신장 트리의 총 가중치 출력
        System.out.println(cost);
    }

    public static void main(String[] args) throws IOException {
        // 간선 입력 받기, 그래프에 저장
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[][] graph = new int[m][3];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken()); // 간선 나가는 정점
            graph[i][1] = Integer.parseInt(st.nextToken()); // 간선 들어오는 정점
            graph[i][2] = Integer.parseInt(st.nextToken()); // 가중치
        }

        // 간선 정렬
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        // 부모노드 초기화
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //크루스칼 알고리즘 수행
        kruskal(graph, parent)
    }
}