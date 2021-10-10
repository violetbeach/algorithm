package skillcheck.level3;

import java.util.ArrayList;

// 하노이의 탑
// 어렵다.. C언어로 분명 쉽게 풀어봤었는데 몇 시간을 노가다 했다.
// 파이팅

public class HanoiTower {
	
	ArrayList<int[]> seq;
    public int[][] solution(int n) {
        seq = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[seq.size()][2];
        for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];  
        }
        
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};
        
        if(n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);   
        }
    }

}
