package skillcheck.level1;

public class Lotto {
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        int zeroCount = 0;
        
        for(int i=0; i<6; i++) {
        	if(lottos[i]==0) zeroCount++;
        	else {
        		for(int j=0; j<6; j++) {
        			if(lottos[i] == win_nums[j]) {
                		answer[0]--;
                		answer[1]--;
                	}
        		}
        	}	
        }
        
        answer[0] -= zeroCount;
        
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;
        return answer;
    }

	public static void main(String[] args) {
		
		int[] lotto = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		System.out.println(solution(lotto, win_nums));	
		
	}
}
