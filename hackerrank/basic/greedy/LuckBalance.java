package greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LuckBalance {
	
	public static int luckBalance(int k, List<List<Integer>> contests) {
	    // Write your code here
		int answer = 0;
		Collections.sort(contests, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> a, List<Integer> b) {
				return b.get(0) - a.get(0);
			}
		});
		for(int i=0; i<contests.size(); i++) {
			if(contests.get(i).get(1) == 0) {
				answer += contests.get(i).get(0);
			} else {
				if(k>0) answer += contests.get(i).get(0);
				else answer -= contests.get(i).get(0);
				k--;
			}
		}
		return answer;

	}
}
