package basic.dp;

import java.util.ArrayList;
import java.util.List;

// 음수를 만날 때 까지의 최댓값을 재귀로 구했음... 한번 꽂히니까 고정관념이 생겼음. 그래도 모든 효율은 통과하긴 했음.
// dp로 계속 해당 인덱스의 합계를 만들고, 기준은 2칸전 합 + 자신 , 1칸전 합, 2칸전 합을 비교를 하면됨.
// 간단한데 음수때문에 구상이 어려웠다. 여러번 풀자.

public class MaxArraySum {
	
	static int countMax = 0;
	
	static int maxSubsetSum(int[] arr) {
		int answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				List<Integer> sub = new ArrayList<>();
				while(i<arr.length && arr[i] > 0) {
					sub.add(arr[i]);
					i++;
				}
				getMax(sub, -2, 0);
				answer += countMax;
				countMax=0;
			}
		}
		
		return answer;

    }
	
	static void getMax(List<Integer> subList, int recent, int count) {
		
		if(count > countMax) countMax = count;
		
		for(int i=recent+2; i<subList.size(); i++) {
			getMax(subList, i, count + subList.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {3, 7, 4, 6, 5};
		System.out.println(maxSubsetSum(a));
	}

}
