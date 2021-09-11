package kakao;

// 숫자 문자열과 영단어
// 정적 필드 변수 올리자..

public class NumberAndString {
	
	private static final String[] word = {"zero", "one", "two", "three", "four", "five",
					 			   "six", "seven", "eight", "nine"};
	
	public int solution(String s) {
		
		s = s.replace(" ", "");

		for(int i=0; i<10; i++) {
			s = s.replace(word[i], Integer.toString(i));
		}

		return Integer.parseInt(s);
		
    }
	
	public static void main(String[] args) {
		
		NumberAndString a = new NumberAndString();
		
		System.out.println(a.solution("00 zero"));	
	}


}