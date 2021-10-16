package kakao;

import java.util.ArrayList;

// 수식 최대화
// 연산이랑 숫자랑 따로 리스트에 담아서, 인덱스로 하나씩 연산하면 된다.

// 그런데 지금 레벨 쯤 되니까 잘하는 사람 코드 찾기가 힘들다. 블로그나 풀이 다 뒤져도 완벽하게 마음에 드는 코드가 없다.
// 백준은 다를까..? 빨리 다 풀고 백준으로 넘어가자

public class MaximizeFormula {
	
	static final String[] orders = {"*+-" , "*-+", "+*-", "+-*", "-+*", "-*+"};
	
	public long solution(String expression) {
        ArrayList<Long> numbers = new ArrayList<>();    
        ArrayList<Character> operators = new ArrayList<>();

        StringBuilder num = new StringBuilder();

        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*'){
                operators.add(expression.charAt(i));
                numbers.add(Long.parseLong(num.toString()));
                num.setLength(0);
            } else num.append(expression.charAt(i));
        }
        
        numbers.add(Long.parseLong(num.toString()));

        Answer answer = new Answer(0);
        for(int i=0; i<6; i++) {
        	operation(numbers, operators, orders[i], answer);
        }

        return answer.max;
    }
	
	public long cal(long a, long b, char op){
        if(op == '+')
            return a + b;
        else if(op == '-')
            return a - b;
        else
            return a * b;
    }

    public void operation(ArrayList<Long> nums, ArrayList<Character> opers, String order, Answer answer){
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        for(int i = 0; i < nums.size(); i++){
            numbers.add(nums.get(i));
        }

        for(int i = 0; i < opers.size(); i++){
            ops.add(opers.get(i));
        }
        
        for(int i=0; i<3; i++) {
        	for(int j = 0; j < ops.size(); j++){
        		if(ops.get(j) == order.charAt(i)){
                    long num1 = numbers.get(j);
                    long num2 = numbers.get(j + 1);
                    long result = cal(num1, num2, ops.get(j));
                    numbers.remove(j);
                    numbers.remove(j);
                    numbers.add(j, result);
                    ops.remove(j);
                    j--;
                }
            }		
    	}

        answer.max = answer.max > Math.abs(numbers.get(0)) ? answer.max : Math.abs(numbers.get(0));

    }
    
    class Answer{
    	long max;
    	
    	Answer(long max){
    		this.max = max;
    	}
    }
    
    public static void main(String[] args) {
    	MaximizeFormula a = new MaximizeFormula();
		String b = "100-200*300-500+20";
		System.out.println(a.solution(b));	
	}

}