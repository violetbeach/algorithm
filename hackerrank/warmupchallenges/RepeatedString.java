package warmupchallenges;

public class RepeatedString {
	
	public static long repeatedString(String s, long n) {
		char[] charArray = s.toCharArray();
		char first = charArray[0];
		int len = s.length();
		long answer = 0;
		
		for(int i=0; i<len; i++) {
			if(charArray[i] == first) answer++;
		}
		
		answer *= n/len;
		
		for(int i=0; i<n%len; i++) {
			if(charArray[i] == first) answer++;
		}
		
		return answer;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 1000000000000L;
		System.out.println(repeatedString("aba", (long)10));
	}

}
