package skillcheck.level2;

import java.util.PriorityQueue;

// 배달
// 단순히 다익스트라 N만큼 반복하면 효율이 안나올 것 같아서 머리로 풀었다.

// 특별한 경우 말고는 가중치 없을 땐 BFS 못 쓴다.
// 가중치가 다르고 음수가 없을 때, 최단 경로를 찾을 때는 다익스트라를 사용함.

// 우선 순위 큐를 안쓴 다익스트라는 0.1ms 미만으로 나왔고, 쓴 것은 1ms미만 정도로 나왔다.
// 이유를 조사해보고자 아무 로직도 없이 우선순위큐를 선언하는 코드만 작성했는데 0.5ms정도 나왔다.
// 정말 효율적이려면 데이터가 크고 연결이 많아야할 것 같다.

public class CountryDelivery {
	public int solution(int N, int[][] road, int K) {
		int matrix[][] = new int[N][N];
		PriorityQueue<Node> q = new PriorityQueue<>();

        for(int i=0;i<road.length;i++) {
            if(matrix[road[i][0]-1][road[i][1]-1] == 0 || 
              matrix[road[i][0]-1][road[i][1]-1] > road[i][2])
                matrix[road[i][0]-1][road[i][1]-1] = 
                    matrix[road[i][1]-1][road[i][0]-1] = road[i][2];
        }

        boolean visits[] = new boolean[N];
        int costs[] = new int[N];
        for(int i=0;i<N;i++) {
            visits[i] = false;
            costs[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<N;i++)
            if(matrix[0][i] > 0) {
                q.add(new Node(i, matrix[0][i]));
                costs[i] = matrix[0][i];
            }
        
        visits[0] = true;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            visits[node.id] = true;
            
            for(int i=0; i<N; i++) {
            	if(!visits[i] && matrix[node.id][i]>0) {
            		q.add(new Node(i, costs[node.id] + matrix[node.id][i]));
            		costs[i] = Math.min(costs[i], node.distance + matrix[node.id][i]);
            	}
            }
            
        }

        int answer = 0;
        for(int i=0;i<N;i++) {
            if(costs[i] <= K)
                answer++;
        }

        return answer;
    }
	
	class Node implements Comparable<Node>{
		int id;
		int distance;
		
		Node(int id, int distance){
			this.id = id;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(distance, n.distance);
		}
		
	}
	
	

	public static void main(String[] args) {
		CountryDelivery a = new CountryDelivery();
		int N = 5;
		int K = 3;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		System.out.println(a.solution(N, road, K));	
	}

}
