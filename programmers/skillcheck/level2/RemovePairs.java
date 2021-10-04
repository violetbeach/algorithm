package skillcheck.level2;

import java.util.Stack;

// 짝지어 제거하기
// 스택을 안쓰면 무슨 짓을 해도 시간 초과난다.
// String Builder로 로직을 정말 간단하게 똑같이 해서 구현했는데도 시간 초과가 났고, delete에서 시간이 굉장히 오래걸렸다.
// sb를써서 삭제를 해도 String보다 나을 뿐이지, 가장 적합한 자료구조를 활용하는 것이 중요하다.

public class RemovePairs {
	
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) 
          if(!stack.isEmpty() && stack.peek() == c) stack.pop();
          else stack.push(c);
         
        return stack.isEmpty() ? 1 : 0;
    }

	public static void main(String[] args) {
		RemovePairs a = new RemovePairs();
		System.out.println(a.solution("baabaa"));
	}

}
