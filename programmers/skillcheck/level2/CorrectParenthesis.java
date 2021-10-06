package skillcheck.level2;

// 올바른 괄호
// 괄호검사라고 반드시 Stack 안써도됨. 검사만 하기 때문

public class CorrectParenthesis {
	boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;

    }
}
