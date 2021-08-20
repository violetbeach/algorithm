package basic.stackque;

import java.util.LinkedList;
import java.util.Queue;

// 프린터
// 보통 사람들은 while문에 큐가 비어있지 않는다는 조건을 준다.
// 입력값이 확실하다는 가정 하에는, 큐가 비어있는지 검사하는 것이 부하낭비라고 생각해서 그냥 true로 했는데, 고민을 해봐야 할 것 같다.
// 변수이름을 즉시 괜찮게 지을 수 있는 습관을 들이자.
// 다른 사람 보다 효율적은 아닐 수 있지만 가독성있게 짰으니 괜찮다.

public class Printer {
	
	static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<P> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
        	queue.add(new P(i, priorities[i]));
        }
        
        while(true) {
        	int first = queue.peek().prior;
        	boolean isPrint = true;
        	
        	for(P q : queue) {
        		if(first < q.prior) {
        			queue.add(queue.poll());
        			isPrint = false;
        			break;
        		}
        	}
        	if(isPrint) {
        		P p = queue.poll();
            	answer++;
            	if(p.loc==location) return answer;
        	}    	
        	
        }
       
    }
	
	static class P {
		int loc;
		int prior;

		P(int loc, int prior) {
			this.loc = loc;
			this.prior = prior;
		}
	}
	
	public static void main(String[] args) {
		
		int[] pri = {2, 1, 3, 2};
		int loc = 2;
		System.out.println(solution(pri, loc));
		
	}
}
