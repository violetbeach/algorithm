package basic.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 앞사람이랑만 바꿀 수 있으니까, 뒤에서 부터 돌려야 안 엉킴. 앞에서 부터 바꾸면 뒤에 녀석이 앞으로 오면서 다시 뒤로 조정해야함.
// 제일 효율적인것은 앞에 뒷사람이 몇명있는지 또는 뒤에 앞사람이 몇명있는지 구하는 거임.
// 왜냐하면 의미있는 (같은 대상 복수가 아닌) 새치기를 할 때 마다 불균형이 하나 생김. 그 불균형 개수가 최소 새치기 수임

public class NewYearChaos {
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
		minimumBribes(a);
	}
	
	public static void minimumBribes(List<Integer> q) {
	    
		int answer = 0;
		
		for(int i=0; i<q.size(); i++) {
			if(q.get(i) > i+3) {
				System.out.println("Too chaotic");
				return;
			}
		}
		
		for(int i=0; i<q.size(); i++) {
			for(int j = Math.max(0, q.get(i) - 2); j<i; j++) {
				System.out.println("i = "+ i + ", j = " + j);
				if(q.get(j) > q.get(i)) 
					System.out.println(q.get(j) +"가 " + q.get(i) + "보다 크니까 1 더합니다.");
					answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
}
