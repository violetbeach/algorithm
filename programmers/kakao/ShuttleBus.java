package kakao;

import java.util.Arrays;

// 셔틀버스
// 복잡하긴 한데, 다른 사람 코드도 엄청 복잡함.
// 퍼포먼스는 엄청 뛰어남(다른 사람 코드보다 4배 정도). 우선순위 큐, 클래스 등을 생략하면서 이점을 봄.
// 대신, 큐를 사용하지 않아서 반복문에 구현해야 하는 부분들이 아주 많아졌음.

// String 형태의 날짜/시간 데이터를 가공하는 게 익숙하지가 않음. 공부해야 할듯
// 구현을 머리속으로 돌리면서 너무 많은 오류륿 범함. 20개의 TC가 주어지지 않았다면 분명 실수했음.

// !!!!! 답이 도출 됬으면 break해서 빠져 나오자..!
// !!! 어떠한 배열이든, 인덱스를 깔끔하게 검증하자

public class ShuttleBus {
	public String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;
        int answer = 0;
        
        Arrays.sort(timetable);
        
        int[] times = new int[len];
        
        int[] cars = new int[n];
        for(int i=0; i<n; i++) {
            cars[i] = 9 * 60 + i * t;
        }
        
        int people = 0;
        int carIdx = 0;
        for(int i=0; i<len; i++) {
            String[] str = timetable[i].split(":");
            times[i] = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            
            // 현재 승객이 막차보다 늦으면, 막차에 탄다.
            if(times[i] > cars[n - 1]) {
                answer = cars[n - 1];
                break;
            }
            
            // 현재 승객이 차보다 빨리 왔고, 차에 자리가 있다면 승객을 태운다.
            // 다음 승객이 없다면 막차를 탄다.
            if(times[i] <= cars[carIdx] && people < m) {
                if(i+1 < len) answer = cars[n - 1];
                people++;
            }
            
            // 현재 차가 막차고, 사람이 꽉찼으면 마지막 승객보다 1분 일찍 탄다.
            if(carIdx == n - 1 && people == m) {
                answer = times[i] - 1;
                break;
            }
            
            // 현재 차가 막차가 아니고, 사람이 꽉찼거나, 현재 승객이 차보다 늦게 왔다면 다음 차로 바꾼다.
            if(carIdx < n - 1 && (people == m || times[i] > cars[carIdx])) {
                if(times[i] > cars[carIdx]) i--;
                carIdx++;
                people = 0;
            }
            
        }
        
        StringBuilder sb = new StringBuilder().append(String.format("%02d", answer/60)).append(":").append((String.format("%02d", answer%60)));
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		ShuttleBus a = new ShuttleBus();
		String[] b = {"09:00", "09:05"};
		System.out.println(a.solution(1,1,1,b));	
	}
}