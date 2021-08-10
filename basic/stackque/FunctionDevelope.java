package basic.stackque;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 기능 개발
// 풀어봤는데 인터넷에 존재하는 모든 테스트 케이스를 통과하는데, 프로그래머스 비공개 TC는 12개 중 3개밖에 통과를 못했다.
// 도저히 뭐가 문제인지 모르겠어서 solution 함수 반환 값을 바꾸지 않고, int[]에 맞춰서 answer를 맞추니 모든 TC를 통과했다.... 반환 값이나 파라미터는 손대지 말자..
// 다른 사람 풀이를 보니 크기가 100인 배열을 만들어서 Arrays.stream().filter로 엄청 짧은 코드로 풀었다.
// 하지만 내생각에 그것은 day가 100이하라는 조건이 있었기 때문에 가능했던 것이지, 실제로 이 로직이 정말 필요한  순간에 사용할 수 없는 코드다.
// 이건 잘 풀은 것 같다.

public class FunctionDevelope {
	
	static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
        	int remainTask = 100-progresses[i];
        	int remainTaskDay = (int)Math.ceil(remainTask/speeds[i]);
        	queue.add(remainTaskDay);
        }

        
        int queueTemp = -1;
        while(!queue.isEmpty()) {
        	int top = queue.poll();
        	System.out.println(top);
        	if(top > queueTemp) {
        		result.add(1);
        		queueTemp = top;
        	} else {
        		result.set(result.size()-1, result.get(result.size()-1) + 1);
        	}
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i] = result.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] pro = {2, 2, 1, 2};
		int[] sp = {1, 1, 1, 1};
		System.out.println(solution(pro,sp));
		
	}
}
