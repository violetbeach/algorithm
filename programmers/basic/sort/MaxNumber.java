package basic.sort;

import java.util.Arrays;
import java.util.Comparator;

// 가장 큰 수
// Comparator 처음 써봤음... 좋은 경험


public class MaxNumber {

	public static String solution(int[] numbers) {
		StringBuilder builder = new StringBuilder();
		
		String[] str = new String[numbers.length];
		for(int i=0; i<numbers.length; i++) {
			str[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});
		
		for(String s : str) {
			builder.append(s);
		}
		
		if(str[0].equals("0")) {
			return "0";
		}
	
		return builder.toString();
    }

	public static void main(String[] args) {
		int[] nums = {3, 330, 30};
		System.out.println(solution(nums));	
	}

}
