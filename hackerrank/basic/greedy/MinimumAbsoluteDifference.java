package greedy;

import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {
	
	public static int minimumAbsoluteDifference(List<Integer> arr) {
	    // Write your code here
		int len = arr.size();
		Collections.sort(arr);
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<len-1; i++) {
			int difference = Math.abs(arr.get(i) - arr.get(i+1));
			min = min > difference ? difference : min;
		}
		
		return min;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
