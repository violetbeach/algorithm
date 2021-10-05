package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 튜플
// 20줄 적어서 맞췄는데, 잘 푼 예제 보니까 감동했음.

// 솔루션 1 배울점 : replaceAll로 정규식 적용해서 거르기
//				  set.add해서 중복 없으면 true return함
//                개수 애매할 때는 배열 인덱스 [] 안에 들어갈 변수에 ++ 해줘서 조건으로 처리 가능함.

// 솔루션 2 배울점 : 정규식을 정확히 사용했음. 데이터 형식이 복잡하고 필요한 값은 간단할 때 완전 좋을 듯.


public class Tuple {
	
	public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
	
	public int[] solution2(String s) {
		Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Tuple a = new Tuple();
		System.out.println(a.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));

	}
}