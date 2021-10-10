package kakao;

import java.util.ArrayList;
import java.util.List;

// 거리두기 확인하기
// 빡구현... 최소 1시간 30분은 걸린 것 같다. ㅠㅠ.. 그런데 다 짜고 보니까 너무 난이도 쉬운 코드로 보인다. 하하. 좀 쉬면서 할걸
// 그래도 다른 사람 풀이 봤는데 훨씬 훨씬 복잡하고 퍼포먼스도 안나온다..! 되게 잘짠거였구나..

// 2중 for문 돌릴 때 두 번째 for문이 x야 !!!! 몇번째야 !!!!!! x랑 y값 객체나 다른 곳에 삽입할 때 조심하자. ij (X) ji (O) ..!

public class CheckDistance {
	public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++) {
            answer[i] = distance(places[i]);
        }
        
        return answer;
    }
    
    int distance(String[] place) {
        List<People> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(place[i].charAt(j) == 'P') {
                    list.add(new People(j, i));
                }
            }
        }
        
        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                People p1 = list.get(i);
                People p2 = list.get(j);
                if(Math.abs(p1.x - p2.x) > 2 || Math.abs(p1.y - p2.y) > 2 || Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) > 2) {
                    continue;
                } else {
                    if(Math.abs(p1.x - p2.x) == 1) {
                        if(place[p1.y].charAt(p2.x) == 'P' || place[p1.y].charAt(p2.x) == 'O') return 0;
                        if(place[p2.y].charAt(p1.x) == 'P' || place[p2.y].charAt(p1.x) == 'O') return 0;
                    } else if(place[p1.y].charAt((p1.x + p2.x) / 2) != 'X' && place[(p1.y + p2.y) / 2].charAt(p1.x) != 'X') {
                        return 0;
                    }
                    
                }
            }
        }
        return 1;
    }
    
    class People{
        int x;
        int y;
        
        People(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
