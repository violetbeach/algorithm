package kakao;

import java.util.Arrays;
import java.util.Stack;

/*
* Kakao - 괄호 회전하기
* char[]는 asList를 사용하면 List<char[]>이 된다. ㅠ
*
* 그리고 Stack 마지막에 비워야 했는데 실수했다.
* */

public class RotateBracket {

    private final Character[] left = {'[', '{', '('};

    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            Stack<Character> stack = new Stack();
            int j = 0;
            for(char bracket: sb.toString().toCharArray()) {
                if(Arrays.asList(left).contains(bracket)) {
                    stack.push(bracket);
                } else {
                    if(!stack.isEmpty() &&
                            ((bracket == ']' && stack.peek() == '[') ||
                            (bracket == '}' && stack.peek() == '{') ||
                            (bracket == ')' && stack.peek() == '('))) {
                        stack.pop();
                        if(j == s.length() - 1 && stack.isEmpty()) {
                            answer++;
                        }
                    } else {
                        break;
                    }
                }
                j++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RotateBracket solution = new RotateBracket();
        System.out.println(solution.solution("()("));
    }
}
