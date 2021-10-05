package skillcheck.level2;

// 숫자의 표현
// 시간초과. 3중 for문 돌려서 당연한 결과였음.
// 개수별로 따로 안구하고, 그냥 2중 for문 돌렸으면 됬음.

public class ExpressingNumbers {
	/*
	 * public int solution(int n) { int answer = 0; for(int i=1; i<=n; i++) {
	 * for(int k=1; k<=n-i+1; k++) { int sum = 0; for(int j=k; j<k+i; j++) { sum +=
	 * j; } if(sum > n) break; if(sum == n) answer++; } } return answer; }
	 */
	
	public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=i; j<=n; j++) {
                sum += j;
                
                if(sum==n) {
                    answer++;
                    break;
                } else if(sum>n) {
                    break;
                }
            }
        }      
        return answer;
    }
	
	public static void main(String[] args) {
		ExpressingNumbers a = new ExpressingNumbers();
		System.out.println(a.solution(15));
	}

}
