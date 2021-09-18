package basic.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 문제 잘못 읽음... 영어라 어렵네. 뒤집어서 똑같은게 아니라 구성이 똑같은게 아나그램임. 예시를 이상하게 들었네.
// 문자열을 일단 해시에 모조리 집어넎고 오름차순으로 해서 검사해나가게끔 구현하면 되었음.

public class SherlockAndAnagrams {
	
	public static int sherlockAndAnagrams(String s) {
	    int len = s.length();
	    StringBuilder sb = new StringBuilder(s);
	    String reverse = sb.reverse().toString();
	    int answer = 0;
	    
	    Map<Integer, Set<Integer>> hm = new HashMap<>();
	    
		for(int i=1; i<len; i++) {
			for(int j=0; j<len-i+1; j++) {
				String sub = s.substring(j, j+i);
				Set<Integer> set = hm.getOrDefault(j, new HashSet<>());
				set.add(i);
				hm.put(j, set);
				for(int k=0; k<len-i+1; k++) {
					if(i+k == len-j) continue;
					if(sub.equals(reverse.substring(k, i+k))) {
						if(hm.containsKey(len-k-i) && hm.get(len-k-i).contains(i)) continue;
						answer++;
					}
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(sherlockAndAnagrams("abba"));
	}
	
}