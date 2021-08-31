package basic.graph;

import java.util.LinkedList;
import java.util.Queue;

// 가장 먼 노드
// 시간초과.... 심지어 남들 실행시간 1000배..^^
// 세상에.. 당연히 재귀라고 생각했는데 재귀함수 쓴놈이 나밖에 없다. 크기가 무지막지한 리스트를 계속 생성해서 오래걸리는 것 같다.
// 그리고 단시간에 방문을 하면 그냥 그 노드를 지워서 다시는 안오는게 맞다.
// 그리고 애초에 스택메모리를 기반으로 하는 재귀함수는 깊이우선 일 수 밖에없는데 너비우선탐색 문제였던 것 같다.
// 처음보는 유형인데, 어렵지만 신기하고 재밌다. 다음엔 잘할 수 있겠어.

public class FurthestNode {
	static int solution(int n, int[][] edge) {
		/*
		 * int answer = 0;
		 * 
		 * List<Integer> distance = new ArrayList<>(); List<List<Integer>> list = new
		 * ArrayList<>();
		 * 
		 * for(int i=0; i<n; i++) { list.add(new ArrayList<>()); distance.add(n); }
		 * 
		 * for(int[] edgeArray : edge) { list.get(edgeArray[0]-1).add(edgeArray[1]-1);
		 * list.get(edgeArray[1]-1).add(edgeArray[0]-1); }
		 * 
		 * recursive(list, distance, 0, n, 0);
		 * 
		 * int max = Collections.max(distance); for(int i=1; i<n; i++) {
		 * if(max==distance.get(i)) answer++; }
		 * 
		 * return answer;
		 */
		
		
	
	/*
	 * static void recursive(List<List<Integer>> dl, List<Integer> distance, int
	 * index, int n, int count) { if(count>=n) return; count++; for(int j=0; j<n;
	 * j++) { if(dl.get(index).contains(j)) { distance.set(j,
	 * Math.min(distance.get(j), count)); recursive(dl, distance, j, n, count); } }
	 * }
	 */
		
		boolean[] check = new boolean[n];
	    boolean[][] connect = new boolean[n][n];
	    Queue<Integer> q = new LinkedList<>();
	    for(int i=0; i<edge.length; i++){
	        connect[edge[i][0]-1][edge[i][1]-1]=true;
	        connect[edge[i][1]-1][edge[i][0]-1]=true;
	    }
	    check[0]=true;
	    q.add(0);

	    int answer = 0;
	    while(!q.isEmpty()){
	        int qSize = q.size();
	        for(int i=0; i<qSize;i++){
	            int node = q.poll();
	            for(int j=0; j<n; j++){
	                if(connect[j][node]&&!check[j]){
	                    check[j]=true;
	                    q.add(j);
	                }
	            }
	        }
	        answer=qSize;
	    }
	    return answer;
	    
    }

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
		System.out.println(solution(n, vertex));	
	}
}
