package basic.binarysearch;

import java.util.Arrays;

public class Stepstones {
	public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int s = 1, e = distance, mid;
        while(s <= e) {
            mid = (s + e) /2;
            int cur = 0;
            int hits = 0;
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - cur < mid) {
                    hits++;
                }
                else {
                    cur = rocks[i];
                }
            }
            if(hits > n) {
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        answer = e;
        return answer;
    }
	
	public static void main(String[] args) {
		Stepstones a = new Stepstones();
		int[] times = {2, 14, 11, 21, 17};
		System.out.println(a.solution(25, times, 2));	
	}
}
