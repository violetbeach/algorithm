package kakao;

import java.util.HashMap;
import java.util.Map;


// 뉴스 클러스터링
// 오늘 무슨 일인지는 모르겠지만 (nhn 코테도 잘봤다.)
// 엄청 잘 풀었다. 가독성도 문제 없고, 프로그래머스나 블로그에 어떤 코드보다 퍼포먼스도 뛰어나다.
// Character.isLetter 또는 Character.isLetterOrDigit 또는 Character.isDigit 간단한 정규식 대신 사용하기 좋은 것 같다. 기억하자!

public class NewsClustering {

	public int solution(String str1, String str2) {
        int n = 65536;
        int union = 0;
        int inter = 0;
        double per = 0;
            
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for(int i=1; i<str1.length(); i++){
            String temp = str1.substring(i-1, i+1).toLowerCase();
            boolean trigger = true;
            for(char c : temp.toCharArray()){
                if(c < 'a' || c > 'z') trigger = false;
            }
            if(trigger) hm1.put(temp, hm1.getOrDefault(temp, 0) + 1);
        }
        
        for(int i=1; i<str2.length(); i++){
            String temp = str2.substring(i-1, i+1).toLowerCase();
            boolean trigger = true;
            for(char c : temp.toCharArray()){
                if(c < 'a' || c > 'z') trigger = false;
            }
            if(trigger) hm2.put(temp, hm2.getOrDefault(temp, 0) + 1);
        }
        
        if(hm1.isEmpty() && hm2.isEmpty()) return n;
        
        for(Map.Entry<String, Integer> entry : hm1.entrySet()){
            if(hm2.getOrDefault(entry.getKey(), 0) == 0) {
                union += entry.getValue();
            } else {
                inter += Math.min(entry.getValue(), hm2.get(entry.getKey()));
                union += Math.max(entry.getValue(), hm2.get(entry.getKey()));
            }
        }
        
        for(Map.Entry<String, Integer> entry : hm2.entrySet()){
            if(hm1.getOrDefault(entry.getKey(), 0) == 0) {
                union += entry.getValue();
            }
        }
        
        per = (double) inter / union;
        
        
        return (int)(n * per);
    }

}
