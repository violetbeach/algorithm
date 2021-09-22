package warmupchallenges;

public class CountingValleys {
	
	public static int countingValleys(int steps, String path) {
	    int answer = 0;
	    
	    int height = 0;
	    for(char c : path.toCharArray()) {
	    	if(c == 'U') {
	    		height++;
	    	} else if(c == 'D') {
	    		if(height == 0) answer++;
	    		height--;
	    	}
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
	}
}
