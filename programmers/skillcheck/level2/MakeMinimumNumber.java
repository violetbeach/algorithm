package skillcheck.level2;

import java.util.Arrays;

// 최솟값 만들기
// 쉬움

public class MakeMinimumNumber {
	public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[A.length-1-i];
        }
        
        return answer;
    }
}
