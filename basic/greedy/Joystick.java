package basic.greedy;

// 조이스틱
// 이해할 때 까지 계속 봤지만, 또 이정도 문제가 나오면 계산해내지 못할 것 같다..
// 그래서 다양한 유형의 문제를 풀고 원리를 응용하는 것이 중요한 것 같다.

public class Joystick {
	
	public static int solution(String name) {
		int answer = 0;
		int len = name.length();
		int min = len-1;
		
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			answer += Math.min(c - 'A', 'Z' - c + 1);	
		}
		
		for(int i=0;i<len;i++){
            int next=i+1;
            while(next<len && name.charAt(next)=='A'){
                next++;
            }                
            min = Math.min(min, i+len-next+i);
        }
		
		
		
		return answer+min;
    }

	public static void main(String[] args) {
		String name = "JEROEN";
		System.out.println(solution(name));	
	}

}
