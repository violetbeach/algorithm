package basic.sort;

import java.util.Arrays;
import java.util.Collections;

// H-Index
// 쉽게 풀었다. 다른 사람꺼 보다 잘 짠것 같다.
// 오름차순이면 가독성이 떨어지고 크게 효율적이지도 않다고 생각한다.

public class HIndex {
	
	public static int solution(int[] citations) {
		int answer = 0;
		Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0; i<citations.length; i++) {
			if(arr[i]>i) answer++;
			else break;
		}
		
		return answer;
    }

	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
		
	}
	
}
