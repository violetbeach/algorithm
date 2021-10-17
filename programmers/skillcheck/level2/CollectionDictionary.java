package skillcheck.level2;

// 모음 사전

// 최적화 + 로직 / 수학적 풀이 / dfs 완전탐색

// 세 가지 모두 중요한 것 같다. 잘 익히자
// str.indexOf 기억하자.

public class CollectionDictionary {
	
	public int solution(String word) {
		String str = "AEIOU";
		int[] x = {781,156,31,6,1};
		int index;
        int result=word.length();
		for(int i=0;i<word.length();i++){
			index = str.indexOf(word.charAt(i));
			result+=x[i]*index;
		}
		return result;
	}
	
	/*
	 * public int solution(String word) { int answer = 0, per = 3905; for(String s :
	 * word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1; return answer;
	 * }
	 */
	
	/*
	 * public int solution(String word) { List<String> list = new ArrayList<>();
	 * dfs("", 0, list); return list.indexOf(word); } void dfs(String str, int len,
	 * List<String> list) { if(len > 5) return; list.add(str); for(int i = 0; i < 5;
	 * i++) dfs(str + "AEIOU".charAt(i), len + 1, list); }
	 */
	
	

}
