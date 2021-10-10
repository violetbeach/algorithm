package skillcheck.level3;

// 멀리 뛰기
// 이것도 피보나치
// 1칸 또는 2칸짜리 선택하는 것은 피보나치일 확률이 매우 매우 높음.

public class LongJump {
	public int solution(int n) {    
        int answer = 1;
        int before = 1;
        
        for(int i=0; i<n-1; i++){
            int temp = answer;
            answer = (answer+before)%1234567;
            before = temp;
        }
        
        return answer;
    }
}
