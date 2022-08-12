package kakao;

import java.util.*;
import java.util.stream.Collectors;

/*
* 야근 지수
*
* 쉬울 것 같았고 실제로도 쉬웠다.
* 알고리즘 테스트는 인터페이스 사용법이 중요하다. Collections.reverseOrder() 기억하자.
* 
* */
public class OvertimeIndex {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.stream(works).boxed().collect(Collectors.toList()));

        while(n > 0) {
            Integer temp = pq.poll();
            if(temp == 0) break;
            pq.add(temp - 1);

            n--;
        }

        return(pq.stream().mapToLong(v -> v * v).sum());
    }
}
