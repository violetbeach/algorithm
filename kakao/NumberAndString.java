package kakao;

public class NumberAndString {
	
	private final String[] word = {"zero", "one", "two", "three", "four", "five",
					 			   "six", "seven", "eight", "nine"};
	
	public int solution(String s) {
		
		s = s.replace(" ", "");

		for(int i=0; i<9; i++) {
			s = s.replace(word[i], Integer.toString(i));
		}

		return Integer.parseInt(s);
		
    }
	
	public static void main(String[] args) {
		
		NumberAndString a = new NumberAndString();
		
		System.out.println(a.solution("00 zero"));	
	}


}