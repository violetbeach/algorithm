package programmers.test2021.kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 신고 결과 받기 - 취준생 당시 코테 풀었던 것 복기

// split(" ") 대신에 더 꼼꼼하게 공백을 잡으려고 split("\\s+")를 사용했는데, 실행시간이 2배로 늘어 남. 고민필요!
// split을 의미 없이 여러번 실행하면서, performance를 다 깎아먹었음. 객체를 재사용하자!

public class Test1 {

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Map<String, Set<String>> hm = new HashMap<>(); // 대상, 신고자 들
		Map<String, Integer> answerCount = new HashMap<>(); // 신고자, 메일 수

		/*for(String str : report) {
			Set<String> set = hm.getOrDefault(str.split("\\s+")[1], new HashSet<>());
			set.add(str.split("\\s+")[0]);
			hm.put(str.split("\\s+")[1], set);
		}*/
		for(String str : report) {
			String[] split = str.split(" ");
			Set<String> set = hm.getOrDefault(split[1], new HashSet<>());
			set.add(split[0]);
			hm.put(split[1], set);
		}

		for(String target : hm.keySet()) {
			Set<String> sub = hm.get(target);
			if(sub.size() >= k) {
				for(String user : sub) {
					answerCount.put(user, answerCount.getOrDefault(user, 0) + 1);
				}
			}
		}

		for(int i=0; i<id_list.length; i++) {
			answer[i] = answerCount.getOrDefault(id_list[i], 0);
		}

		return answer;
	}

	public static void main(String[] args) {
		Test1 a = new Test1();
		String[] b = {"muzi", "frodo", "apeach", "neo"};
		String[] c = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(a.solution(b, c, 2));	
	}
}
