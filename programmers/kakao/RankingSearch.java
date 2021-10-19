package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 순위 검색

// 카카오는 비트연산 문제가 너무 많다.
// 선형탐색을 하다가 효율이 도저히 안나와서 비트 연산자를 통한 순열을 이용해서 다시 짰다.

// 배울점이 많았다..!

// 1. hashmap.computeIfAbsent(key, s -> default)를 사용하면 Collections 종류를 getOrDefault를 해서 put할 수 있다.
//    반환 값이 참조 값이기 때문에, 메서드를 사용해서 수정도 가능하다!

// 2. 비트 연산을 이용해서 순열, 부분집합 등을 구할 수 있다. 비트 연산을 연습하자 !

// 3. 당연한 부분이지만, 맵에서 value을 참조만 해서 정렬할 수도 있다.

// 4. Java8부터 String.join을 이용해서 간단한 문자열을 합칠 수 있다. 하지만, 효율은 안 좋다.


public class RankingSearch {
	public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infos = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
            entry.getValue().sort(null);

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] split = query[i].replace("-", "").replace("and", "").split("\\s+");
            for(int j=0; j<split.length - 1; j++) {
                sb.append(split[j]);
            }
            int score = Integer.parseInt(split[split.length-1]);
           
            List<Integer> list = infos.getOrDefault(sb.toString(), new ArrayList<>());

            int s = 0;
            int e = list.size();

            while (s < e) {
                int mid = (s + e) / 2;

                if (list.get(mid) < score) s = mid + 1;
                else e = mid;
            }

            answer[i] = list.size() - e;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		RankingSearch a = new RankingSearch();
		String[] b = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] c = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(a.solution(b, c));	
	}
}
