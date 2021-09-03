package skillcheck.level2;

// 잘 풀었다. 사람들은 코드 간단하게 한답시고 answer 더하고있는데, 그렇게 했을때 1~2초 정도다.
// StringBuilder쓰면 0.1~0.3초 안에 끝난다. 이래서 CS지식이 정말 정말 중요한 것 같다.
// 프로그래머스에서는 모든 입력값을 고려해야하는 것 같다. 공백을 자르거나 하면 TC돌릴 때 어디서 에러나는지도 못찾는다.

public class JadenCase {
	
	public static  String solution(String s) {
		String[] sp = s.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for(String ss : sp) {
            if(flag) sb.append(ss.toUpperCase());
            else sb.append(ss);
            flag = ss.equals(" ") ? true : false;
        }

        return sb.toString();
    }

	public static void main(String[] args) {
		
		System.out.println(solution("3people unFollowed me"));	
	}

}
