package basic.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 그냥 put하기 전에 조건 검사하고 put하면 순서 걱정없고 반복문 또 안돌려도됨. 코드도 몇 줄 안됨.

public class IceCreamParlor {
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(4, 3, 2, 5, 7));
		int b = 8;
		whatFlavors(a, b);
	}
	
	public static void whatFlavors(List<Integer> cost, int money) {
	    // Write your code here
		Map<Integer, List<Integer>> map = new HashMap<>();
		int len = cost.size();
		for(int i=0; i<len; i++) {
			List<Integer> indexList = map.getOrDefault(cost.get(i), new ArrayList<>());
			indexList.add(i+1);
			map.put(cost.get(i), indexList);
		}
		
		for(Integer costTemp : cost) {
			int first = map.get(costTemp).get(0);
			List<Integer> indexList = map.getOrDefault(costTemp, new ArrayList<>());
			indexList.remove(0);
			if(indexList.size()==0) map.remove(costTemp);
			else map.put(costTemp, indexList);
			
			if(map.containsKey(money-costTemp)) {
				map.put(costTemp, indexList);
				System.out.println(first + " " + map.get(money-costTemp).get(0));
				return;
			}
		}
	}

}