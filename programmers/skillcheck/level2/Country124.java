package skillcheck.level2;

// 124 나라의 숫자
// 진법을 잘 알아야 함

public class Country124 {
	
	private final static String[] num = {"1", "2", "4"};
	
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();

		while(n > 0){
			sb.insert(0, num[(n-1)%3]);
			n = (n-1) / 3;
			}
		return sb.toString();
    }

	public static void main(String[] args) {
		Country124 a = new Country124();
		System.out.println(a.solution(40));	
	}

}
