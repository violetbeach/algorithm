package basic.hash;

import java.util.HashMap;

// 사람들이 칭송하던 스트림, 람다식으로 4줄만에 짠 코드를 돌려봤는데, TC3개에 각각 7ms 8ms 21ms 나왔고,
// 내 코드는 0.008, 0.06, 0.09ms가 나왔다. 다행이고, 잘풀었다.


public class Camouflage {
	
	static int solution(String[][] clothes) {
		int answer = 0;
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(String[] c : clothes) {
			hm.put(c[1], hm.getOrDefault(c[1], 0) + 1);
		}
		
		for(String key : hm.keySet()) {
			answer = answer + (answer * hm.get(key)) + hm.get(key);
		}
		
        return answer;
    }

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		System.out.println(solution(clothes));
	}

}
