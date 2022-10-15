package skillcheck.level3;

/*
* 등산코스 정하기
*
* 출발지를 다 넣고 custom 다익스트라를 돌려야 한다.
*
* 바킹독님은 이분탐색을 돌렸는데 일부(Worst case)는 처리 시간이 더 빨랐다.
*
* 그림을 그려 보는 게 중요하다..!
*
* */

import java.util.*;

public class MountainCourse {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        int[] dist = new int [n+1];
        // int[][] map = new int [n+1][n+1];
        List<Node>[] map = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) map[i] = new ArrayList<>();

        Arrays.fill(dist, 10000001);

        int[] check = new int[n+1];

        for(int i=0;i<gates.length;i++){
            check[gates[i]]=-1;
        }

        for(int i=0;i<summits.length;i++){
            check[summits[i]]=-2;
        }


        for(int i =0;i<paths.length;i++){

            int s = paths[i][0];
            int e = paths[i][1];
            int d = paths[i][2];

            if(check[s]==-1||check[e]==-2){
                map[s].add(new Node(e,d));
            }
            else if(check[e]==-1||check[s]==-2){
                map[e].add(new Node(s,d));
            }
            else{
                map[e].add(new Node(s,d));
                map[s].add(new Node(e,d));
            }
        }

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(o->o.dist));

        //초기값
        for(int g: gates){
            dist[g]=0;

            pq.add(new Node(g,dist[g]));
        }

        while(!pq.isEmpty()){

            Node current = pq.poll();

            int idx =current.index;

            if(current.dist > dist[current.index]){
                continue;
            }

            for(Node node : map[idx]){
                if(dist[node.index] > Math.max(dist[idx],node.dist)){
                    dist[node.index] = Math.max(dist[idx],node.dist);
                    pq.add(node);
                }
            }
        }

        Arrays.sort(summits);

        int[] result = new int[]{0, Integer.MAX_VALUE};


        for (int summit : summits) {
            if (dist[summit] < result[1]) {
                result[1] = Math.min(result[1], dist[summit]);
                result[0] = summit;
            }
        }

        return result;
    }

    class Node {

        public int index;
        public int dist;

        public Node(int index, int dist){
            this.index=index;
            this.dist=dist;
        }

    }
}
