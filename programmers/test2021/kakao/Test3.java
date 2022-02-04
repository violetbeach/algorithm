package programmers.test2021.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 주차 요금 계산
// # 취준생 당시 코테 풀었던 것 복기

// Map을 두개 쓰는데 낭비다. Map안에 배열을 넣든 객체를 넣든 리스트를 넣든 할 수 있었다.

// 언어를 Java로 개발했다면, 클래스를 사용해서 객체 지향을 이루어 내는 게 좋을 것 같다.

public class Test3 {

	public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> timeMap = new HashMap<>(); // 번호별 입차 시각
        Map<String, Integer> tempMap = new HashMap<>(); // 번호별 누적 시간
        
        for(String record : records) {
        	String[] str = record.split("\\s+");
        	int time = Integer.parseInt(str[0].split(":")[0]) * 60 + Integer.parseInt(str[0].split(":")[1]);
        	
        	if(str[2].equals("IN")) {
        		timeMap.put(str[1], time);
        	} else {
        		int start = timeMap.get(str[1]);
        		tempMap.put(str[1], tempMap.getOrDefault(str[1], 0) + time-start);
        		timeMap.remove(str[1]);
        	}
        }
        
        for(String id : timeMap.keySet()) {
        	tempMap.put(id, tempMap.getOrDefault(id, 0) + 1439-timeMap.get(id));
        }
        
        Object[] carIds = tempMap.keySet().toArray();
        Arrays.sort(carIds);
        
        int[] costs = new int[carIds.length];
        for(int i=0; i<carIds.length; i++) {
        	int time = Math.max(0, tempMap.get(carIds[i]) - fees[0]);
        	int count = (time % fees[2] != 0) ? (time / fees[2]) + 1 : time / fees[2];
        	
        	costs[i] = fees[1] + count * fees[3];
        }
        	
        return costs;
    }


	public static void main(String[] args) {
		Test3 a = new Test3();
		int[] fees = {180, 5000, 10, 600};
		String[] b = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(a.solution(fees, b));	
	}
}
