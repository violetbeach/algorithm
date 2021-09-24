package warmupchallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalesByMatch {
	public static int sockMerchant(int n, List<Integer> ar) {
	    // Write your code here
		int answer = 0;
		Set<Integer> set = new HashSet<>();
		
		for(Integer sock : ar) {
			boolean isThere = set.contains(sock);
			if(isThere) {
				answer++;
				set.remove(sock);
			} else set.add(sock);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		List<Integer> b = new ArrayList<>(
				Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
		System.out.println(sockMerchant(9, b));	
	}
}
