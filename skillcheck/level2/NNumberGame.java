package skillcheck.level2;

// n진수 게임
// 조건문 간결할수록 performance가 좋아짐
// 자바도 왠만한 함수는 다 내장되어 있다. (진법 전환)

public class NNumberGame {
	
	public String solution(int n, int t, int m, int p) {

	    int startNum = 0;

	    StringBuilder sb = new StringBuilder();
	    StringBuilder sb2 = new StringBuilder();
	      
	    while (sb.length() < m * t) {
	        sb.append(Integer.toString(startNum++, n));
	    }

	    for (int i=0; i<t; i++) {
	        sb2.append(sb.charAt(p - 1 + i * m));
	    }

	      return sb2.toString().toUpperCase();
    }

	public static void main(String[] args) {
		NNumberGame a = new NNumberGame();
		int n = 16;
		int t = 16;
		int m = 2;
		int p =1;
		System.out.println(a.solution(16, 0, 2, 1));	
	}

}
