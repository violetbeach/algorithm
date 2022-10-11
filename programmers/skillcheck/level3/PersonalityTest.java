package skillcheck.level3;

import java.util.HashMap;
import java.util.Map;

/*
* 성격 유형 검사하기
*
* */

public class PersonalityTest {

    public String solution(String[] survey, int[] choices) {
        int len = survey.length;

        Map<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < len; i++) {
            if(choices[i] > 4) {
                int score = hm.getOrDefault(survey[i].substring(1, 2), 0);
                score += choices[i] - 4;
                hm.put(survey[i].substring(1, 2), score);
            } else {
                int score = hm.getOrDefault(survey[i].substring(0, 1), 0);
                score += 4 - choices[i];
                hm.put(survey[i].substring(0, 1), score);
            }
        }
        String answer = "";

        answer += hm.getOrDefault("R", 0) >= hm.getOrDefault("T", 0) ? "R" : "T";
        answer += hm.getOrDefault("C", 0) >= hm.getOrDefault("F", 0) ? "C" : "F";
        answer += hm.getOrDefault("J", 0) >= hm.getOrDefault("M", 0) ? "J" : "M";
        answer += hm.getOrDefault("A", 0) >= hm.getOrDefault("N", 0) ? "A" : "N";

        return answer;
    }

}
