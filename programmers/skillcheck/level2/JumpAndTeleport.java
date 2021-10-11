package skillcheck.level2;

// 점프와 순간 이동

// 리스트를 쓸 필요가 없었고. n이면 될 것을 복사한다고 2n을 사용했다.
// 역순에 익숙해져야 할 것 같다. 역순으로 복사할 필요 없이, 그냥 역순 상태로 처리하면 되는 것.

public class JumpAndTeleport {
	/*
	 * public int solution(int n) { int ans = 0;
	 * 
	 * List<Integer> list = new ArrayList<>(); int target = n; while(target != 0) {
	 * list.add(target); target /= 2; }
	 * 
	 * int cnt = 0; for(int i=list.size()-1; i>=0; i--) { int temp = list.get(i);
	 * if(cnt * 2 <= temp) cnt *=2; ans += temp - cnt; cnt = temp; }
	 * 
	 * return ans; }
	 */
	
	public int solution(int n) {
        int ans = 0;
        while(n != 0){
            if(n % 2 == 1){
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }
}
