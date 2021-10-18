package kakao;

import java.util.LinkedList;
import java.util.Queue;

// 캐시

// 캐시 사이즈가 0인 경우도 들어오는데, 문제 없이 동작 할거라 생각했다.
// 시간이 빠듯하지 않는다면, 양끝단정도는 확인하자.

public class Cache {
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            String s = cities[i].toLowerCase();
            if(q.contains(s)) {
                answer++;
                q.remove(s);
            } else {
                if(q.size() == cacheSize) q.poll();
                answer += 5;
            }
            if(q.size() < cacheSize) q.offer(s);
        }
        
        
        return answer;
    }
}
