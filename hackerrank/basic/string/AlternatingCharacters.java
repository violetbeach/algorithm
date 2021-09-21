package basic.string;

public class AlternatingCharacters {
	
	public static int alternatingCharacters(String s) {
	    // Write your code here
		
		char temp = 0;
		int answer = 0;
		
		for(char c : s.toCharArray()) {
			if(temp == c) answer++;
			temp = c;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(alternatingCharacters("AAAA"));
	}

}
