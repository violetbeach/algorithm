package basic.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	public static void countSwaps(List<Integer> a) {
	    // Write your code here
		
		int count = 0;
		
		for(int i = 0; i<a.size()-1; i++) {
			for(int j=0; j<a.size()-i-1; j++) {
				if(a.get(j) > a.get(j+1)) {
					int temp = a.get(j);
					a.set(j, a.get(j+1));
					a.set(j+1, temp);
					count++;
				}
			}
		}
		
		System.out.println("Array is sorted in " + count + " swaps.");
		System.out.println("First Element: " + a.get(0));
		System.out.println("Last Element: " + a.get(a.size()-1));
	}
	
	
	public static void main(String[] args) {
		List<Integer> b = new ArrayList<>(Arrays.asList(3, 2, 1));
		countSwaps(b);
	}

}
