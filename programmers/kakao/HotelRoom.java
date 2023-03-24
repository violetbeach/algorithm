package kakao;

import java.util.HashMap;
import java.util.Map;

/*
* 호텔 방 배정
*
* 증가를 해나가면서 지난 데이터를 업데이트 시켜줘야 되는 문제 (DP와 유사)
*
* Map에다가 다음 노드를 저장 (재귀를 통해서 호출한 노드를 계속 구해서, 각 재귀 흐름에서 Map에 다음 번호를 저장하는 방식)
*
* */

public class HotelRoom {
    public long[] solution(long k, long[] room_number) {
        Map<Long, Long> roomMap = new HashMap<>();
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long want = room_number[i];
            long assign = assignRoom(roomMap, want);
            answer[i] = assign;
        }
        return answer;
    }

    private long assignRoom(Map<Long, Long> roomMap, long want) {
        if (!roomMap.containsKey(want)) {
            roomMap.put(want, want+1);
            return want;
        }
        long next = roomMap.get(want);
        long assign = assignRoom(roomMap, next);
        roomMap.put(want, assign);
        return assign;
    }
}
