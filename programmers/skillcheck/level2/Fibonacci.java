package skillcheck.level2;

// 피보나치 수
// 엄청나게 쉬운 문제인데도 빨리 해결을 못한다.
// 머리로 연산 돌리는 과정을 다시 가다듬어야 할듯..

public class Fibonacci {
	public int solution(int n) {    
        int answer = 1;
        int before = 1;
        
        for(int i=0; i<n-2; i++){
            int temp = answer;
            answer = (answer+before)%1234567;
            before = temp;
        }
        
        return answer;
    }
}
