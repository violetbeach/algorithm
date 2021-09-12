package basic.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(rotLeft(a, 4));
	}
	
	public static List<Integer> rotLeft(List<Integer> a, int d) {
	    
		int size = a.size();
		int count = d % size;
		
		for(int i=0; i<count; i++) {
			int temp = a.get(0);
			a.remove(0);
			a.add(temp);
		}
		
		return a;

	}
	
}
