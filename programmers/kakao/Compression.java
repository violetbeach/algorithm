package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 압축
// 잘짰음. 가독성 문제 없고, 퍼포먼스 남들보다 훨씬 훨씬 빠름.
// 요즘 잘하는듯. 기본기랑 효율 같은 거 연구를 계속한 보람이 이제 폭발하는듯 ㅎㅅㅎ 뿌듯!!

public class Compression {
	public int[] solution(String msg) {
        int len = msg.length();
        int dic = 1;
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(; dic<27; dic++) hm.put(Character.toString((char) ('A' + dic - 1)), dic);
        
        for(int i=0; i<len; i++){
            int count = i;
            StringBuilder sb = new StringBuilder();
            while(count < len) {
                sb.append(msg.charAt(count));
                count++;
                if(!hm.containsKey(sb.toString())) {
                    hm.put(sb.toString(), dic);
                    dic++;
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }
            answer.add(hm.get(sb.toString()));
            i += sb.length() - 1;
        }
        
        int[] answerArray = new int[answer.size()];
        for(int i=0; i<answerArray.length; i++) {
            answerArray[i] = answer.get(i);
        }
        return answerArray;
    }
	
	public static void main(String[] args) {
		Compression a = new Compression();
		String b = "KAKAO";
		System.out.println(a.solution(b));	
	}
}
