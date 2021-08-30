package basic.greedy;

import java.util.Arrays;

// 구명보트
// 2중 반복문을 재귀함수로 돌렸더니 대부분 시간초과가 나온다.. 사실상 3중, 4중 반복문..
// 아씨...ㅠㅠ 구명보트는 최대 2명만 탈 수 있다고 한다.. 못보고 풀었다.
// 정렬 해서 그냥 두명씩 더해서 푼다.

public class LifeBoat {
	/*
	 * public static int solution(int[] people, int limit) {
	 * 
	 * int len = people.length; int answer = len;
	 * 
	 * for(int i=0; i<len-1; i++) { for(int j=i+1; j<len; j++) { if(people[i] +
	 * people[j] <= limit) { answer = Math.min(answer, rec(people, limit, i, j,
	 * len)); } } }
	 * 
	 * return answer; }
	 * 
	 * public static int rec(int[] people, int limit, int i, int j, int len) {
	 * people[i] = people[i] + people[j]; people[j] = 0; len--;
	 * 
	 * for(; i<len-1; i++) { for(j=i+1; j<len; j++) { if(people[i]!=0 &&
	 * people[j]!=0 && people[i] + people[j] <= limit) { len = rec(people, limit, i,
	 * j, len); } } }
	 * 
	 * return len;
	 * 
	 * }
	 */
	
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
	}

	public static void main(String[] args) {
		
		int[] people = {1, 2, 99, 100};
		int limit = 100;
		System.out.println(solution(people, limit));
	}
	
}