package skillcheck.level2;

import java.util.LinkedList;
import java.util.Queue;

// 예상 대진표
// 한 과정씩 구현하는 것이 절대 아닐 것이라고 생각했지만, 생각이 안나서 결국 구현해서 다 통과했는데 너무 오래걸렸다.
// XOR을 사용한 천재가있고 그냥 속해있는 스테이지 별로 계산해서, a b대신에 스테이지를 넣어주고 만나게 할 수도 있는데
// 앞으로는 확신을 가질 때 까지 고민하고 풀이하자. 확신이 안 선다면 경험을 쌓고 공부하자..

public class ExpectedMatch {
	
	/*
	 * public int solution(int n, int a, int b){ int answer = 1; n = n / 2;
	 * 
	 * int[][] match = new int[n][2]; for(int i=0; i<n;i++) { match[i][0] =
	 * ((i+1)*2) - 1; match[i][1] = ((i+1)*2);
	 * 
	 * }
	 * 
	 * while(true) { Queue<Integer> q = new LinkedList<>();
	 * 
	 * for(int i=0; i<n; i++) { if((a==match[i][0] && b==match[i][1]) ||
	 * (b==match[i][0] && a==match[i][1])) { return answer; } else if(a ==
	 * match[i][0] || a == match[i][1]) { q.add(a); } else if(b == match[i][0] || b
	 * == match[i][1]) { q.add(b); } else { q.add(match[i][0]); } } n = n / 2;
	 * 
	 * match = new int[n][2]; int i=0; while(i<n) { match[i][0] = q.poll();
	 * match[i][1] = q.poll(); i++; }
	 * 
	 * answer++;
	 * 
	 * } }
	 */
	
	/*
	 * public int solution(int n, int a, int b) { return
	 * Integer.toBinaryString((a-1)^(b-1)).length(); }
	 */
	
	
	public int solution(int n, int a, int b){
		int round = 0;
		
		while(a != b) {
			a = a/2 + a%2;
			b = b/2 + b%2;
			round++;
		}
		
		return round;
		
	}
	 

	public static void main(String[] args) {
		ExpectedMatch a = new ExpectedMatch();
		System.out.println(a.solution(8, 4, 7));	
	}

}
