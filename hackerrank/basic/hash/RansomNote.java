package basic.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RansomNote {

	public static void checkMagazine(List<String> magazine, List<String> note) {
	    // Write your code here
		
		boolean flag = true;
		
		for(int i=0; i<note.size(); i++) {
			if(!magazine.contains(note.get(i))) {
				flag = false;
				break;
			}
			String temp = note.get(i);
			note.set(i, null);
			if(note.contains(temp)) {
				flag = false;
				break;
			}
			
		}
		
		if(flag) System.out.println("Yes");
		else System.out.println("No");

	}
	
	public static void main(String[] args) {
		List<String> a = new ArrayList<>(Arrays.asList("give", "me", "one", "grand", "to", "night"));
		List<String> b = new ArrayList<>(Arrays.asList("give","one", "grand", "night"));
		checkMagazine(a, b);
	}

}
