package skillcheck.level2;

import java.util.HashSet;
import java.util.Set;

// 영어 끝말 잇기
// 쉬운 문제지만 아주 잘짰음.

public class WordChain {
	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        char tail = words[0].charAt(0);
        for(int i=0; i<words.length; i++) {
            if(!set.add(words[i]) || tail != words[i].charAt(0) || words[i].length() == 1) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            tail = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}