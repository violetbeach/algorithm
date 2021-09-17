package basic.string;

import java.util.HashSet;
import java.util.Set;

public class MakingAnagrams {
	
	public static int makeAnagram(String a, String b) {
	    Set<Character> set = new HashSet<>();
	    Set<Character> set2 = new HashSet<>();
	    int answer = 0;
	    
	    for(char c : a.toCharArray()) {
	    	set.add(c);
	    }
	    
	    for(char c : b.toCharArray()) {
	    	set2.add(c);
	    }
	    
	    for(char c : a.toCharArray()) {
	    	if(!set2.contains(c)) answer++;
	    }
	    
	    for(char c : b.toCharArray()) {
	    	if(!set.contains(c)) answer++;
	    }
	    
	    return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
