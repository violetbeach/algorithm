package basic.hash;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
	public static String twoStrings(String s1, String s2) {
	    // Write your code here
		Set<Character> set = new HashSet<>();
		boolean flag = false;
		
		for(char c : s1.toCharArray()) {
			set.add(c);
		}
		
		for(char c : s2.toCharArray()) {
			if(set.contains(c)) {
				flag = true;
				break;
			}
		}
		
		return flag ? "YES" : "NO";
	}
	
	public static void main(String[] args) {
		System.out.println(twoStrings("hello", "world"));
	}
	
}
