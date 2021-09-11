package basic.heap;

import java.util.PriorityQueue;

// 더 맵게
// 정렬을 이용해서 가장 낮은 수 두개를 합치는 것을 반복하는 로직으로 해결하고자 했다.. 좋은 결과가 나오지 않을 것 같았는데 아이디어를 너무 가볍게 생각했다..
// 모든 테스트를 통과 했지만, 효율성 검사에서 모두 시간 초과다.. ArrayList에서 삽입, 삭제, 정렬을 하니까 당연한 결과다.

/*public class MoreSpice {
	
	static int solution(int[] scoville, int K) {
		
		int answer = 0;
		
		Arrays.sort(scoville);
		
		List<Integer> tree = new ArrayList<>();
		for(int i : scoville) {
			tree.add(i);
		}
		
		int min = 0;
		while(true) {
			if(tree.get(0) < K) {
				if(tree.size()==1) return -1;
				
				tree.set(0, tree.get(0) + tree.get(1) * 2 );
				tree.remove(1);
				Collections.sort(tree);
				answer++;
			} else {
				return (answer == 0) ? -1 : answer;
			}
		}
		
    }
		
	public static void main(String[] args) {
		
		int[] scov = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scov,k));
		
	}

}*/

// 다른 사람이 한 우선순위 큐로 만든 최소 힙 알고리즘이다. 내가 작성한 알고리즘과 원리는 같지만만 더 효율적이다.
// 우선순위 큐를 이용하면 최대 힙(Reverse), 최소 힙을 만들 수 있다.

public class MoreSpice {
	
	static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i : scoville) {
			minHeap.add(i);
		}
		
		while(minHeap.peek() < K) {
			
			if(minHeap.size()==1) {
				answer = -1;
				break;
			}
			
			int min1 = minHeap.poll();
			int min2 = minHeap.poll();
			
			minHeap.add(min1 + min2*2);
			answer++;
			
			if(minHeap.peek() >= K) {
				break;
			}	

		}
		
		return answer;
		
    }
		
	public static void main(String[] args) {
		
		int[] scov = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scov,k));
		
	}

}
