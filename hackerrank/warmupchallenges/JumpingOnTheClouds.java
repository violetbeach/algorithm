package warmupchallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpingOnTheClouds {
	
	public static int jumpingOnClouds(List<Integer> c) {
	    // Write your code here
		int answer = 0;
		int len = c.size();
		
		for(int i=0; i<len-1; i++) {
			if(i+2 < len && c.get(i+2) == 0) {
				i++;
			} else if(i+1 < len && c.get(i+1) == 1) {
				i++;
			}
			answer++;
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		List<Integer> b = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 1, 0));
		System.out.println(jumpingOnClouds(b));	
	}

}