package basic.hash;

import java.util.HashMap;

// 완주하지 못한 선수
// 카테고리는 해시였지만 해시를 많이 안써봐서 잘 몰랐다.
// 아는 것으로 풀어보고 싶어서 반복문으로 허접하게 풀었다.

/*public class Marathon {

	static String solution(String[] participant, String[] completion) {

		String answer = "";

		for (int i = 0; i < participant.length; i++) {
			for (int j = 0; j < completion.length; j++) {
				if (participant[i].equals(completion[j])) {
					participant[i] = "";
					completion[j] = "";
				}
			}
		}

		for (int i = 0; i < participant.length; i++) {
			if (!participant[i].equals("")) {
				answer = participant[i];
			}
		}

		return answer;

	}

}*/
 

// 배열을 정렬해서 각 자리마다 비교할 수도 있었다.
// 다른 사람이 푼 해시를 사용한 방법은 시간복잡도가 O(n) 이었다.

public class Marathon {

	static String solution(String[] participant, String[] completion) {

		String answer = "";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (String p : participant)
			hm.put(p, hm.getOrDefault(p, 0) + 1);
		
		for(String c : completion)
			hm.put(c, hm.get(c) - 1);
		
		for(String key : hm.keySet()) {
			if(hm.get(key) != 0){
				answer = key;
				break;
			}
		}
		
		return answer;

	}

	public static void main(String[] args) {
		String[] par = {"mislav", "stanko", "mislav", "ana"};
		String[] com = {"stanko", "ana", "mislav"};

		System.out.println(solution(par, com));

	}

}
