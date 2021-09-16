package basic.search;

import java.util.ArrayList;
import java.util.List;

public class SwapNodes {
	
	public static List<Integer> swapNodes(
			List<List<Integer>> indexes,
			List<Integer> queries) {
		
		List<Integer> answer = new ArrayList<>();
		
		int len = indexes.size();
		/* boolean[] haveToSwap = new boolean[len]; */
		
		for(int height : queries) {
			for(int i=height-1; i<len; i++) {
				int temp = indexes.get(i).get(0);
				indexes.get(i).set(0, indexes.get(i).get(1));
				indexes.get(i).set(1, temp);
			}
		}
		
		/*
		 * for(int i=1; i<len; i++) { if(haveToSwap[i] == true) { int temp =
		 * indexes.get(i).get(0); indexes.get(i).set(0, indexes.get(i).get(1));
		 * indexes.get(i).set(1, temp); } }
		 */
		
		return answer;
			
	}
}
