package kakao;

import java.util.Stack;

// 문자열 압축
// 풀다가 잘 못 풀어서 검색을 해봤는데, 다른 사람이 돌린 코드를 이해하기 앞서 효율을 봤는데
// 대부분 다 30~100ms였다. 내 코드는 완성됬는데 결과가 조금 틀린 거라 효율만 확인하려고 돌려봤는데
// 전부 10ms 미만이었다.. 그래서 내 코드를 다시 짰고 풀이 중 가장 효율적인 코드를 만들었다.
// 다만 코딩하다보면 반복문을 돌릴 때, i랑 j와 같은 것들이 너무 헷갈린다.
// 미친듯이 디버그 찍다가 이 전에 했던 작업들에 대해 다시 연구해야 했다.
// next 등의 변수를 사용해서  +1, -1 이런거좀 없애자. 계속 나온다. 
// 그리고 주석좀 달자.
// 너무 지저분하다.

public class StringCompression {
	public int solution(String s) {
        int answer = 1000;
        int len = s.length();
       
        for(int i=0; i<s.length(); i++) {
        	Stack<String> stack = new Stack<>();
        	for(int j=0; j<len; j+=i+1) {
        		int count = 1;
        		while(!stack.empty() && j+i+1<=len && stack.peek().equals(s.substring(j, j + (i+1)))) {
        			count++;
        			j = j + (i + 1);
        		}
        		if(count != 1) {
        			String temp = stack.pop();
        			stack.push(Integer.toString(count));
        			stack.push(temp);
        		}
        		if(j + i + 1 < len) stack.push(s.substring(j, j + (i+1)));
        		else stack.push(s.substring(j, len));
        	}
      
        	int size = 0;
        	while(!stack.empty()) {
        		size += stack.pop().length();
        	}
        	answer = Math.min(answer, size);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		StringCompression a = new StringCompression();
		System.out.println(a.solution("ababcdcdababcdcd"));	
	}
}
