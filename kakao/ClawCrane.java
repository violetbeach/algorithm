package kakao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 인형 뽑기
// 나름 잘 풀은 것 같다.
// 남들은 죄다 리스트를 썼지만 효율성에서는 비슷한 것 같다.
// 아마 데이터가 어마무시하게 많아 진다면 삭제에 연산이 많아져서 내 코드가 이기지 않을까 싶다..
// 다만, 실제 게임이었으면 절대로 인형을 다 뽑고나서 스택에서 터지게 처리할 수는 없다.
// 인형을 뽑은 즉시 터지게 처리하는게 맞다.

public class ClawCrane {
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int len = board.length;
        int movesCount = 0;
        
        while(movesCount<moves.length) {
        	for(int i=0; i<len; i++) {
        		int cur = board[i][moves[movesCount] - 1];
        		if(cur != 0) {
        			q.add(cur);
        			board[i][moves[movesCount]-1] = 0;
        			break;
        		}
        	}
        	movesCount++;
        }
        
        
        while(!q.isEmpty()) {
        	while(!stack.isEmpty() && q.peek() == stack.peek()) {
        		q.poll();
        		stack.pop();
        		answer += 2;
        	}
        	stack.add(q.poll());
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		int[][] a = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] b = {1,5,3,5,1,2,1,4};
		System.out.println(solution(a, b));	
	}

}
