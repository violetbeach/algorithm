package programmers.test2021.kakao;

// 양궁대회
// # 취준생 당시 코테 풀었던 것 복기

// 디버깅에 너무 의존하다보니, 비트마스킹을 사용할 생각을 하지 못했다.
// 어차피 완탐을 해야하는데, 그럴꺼면 비트마스킹을 이용해서 비교를 하는 게 효율이 좋았다.

// 단점은, DP랑 다르게 모든 완탐을 처음부터 연산해야 한다. (공간복잡도는 낮아지지만 시간복잡도는 높아짐)
// DP 0.25ms 86MB <-> 비트마스킹 0.46ms 68MB

// 배열 리터럴을 리턴할 때는 << return new int[] {-1} >> 형식을 사용할 수 있다.

public class Test4 {

	// a가 b보다 더 좋은 배치일 경우 true
	public boolean isLowShot(int[] a, int[] b){
		for(int i = 10; i >= 0; i--)
			if(a[i] != b[i]) return a[i] > b[i];
		return false;
	}



	public int[] solution(int n, int[] info) {
		int[] best = new int[11];
		int max = Integer.MIN_VALUE;

		for(int brute = 0; brute < 1024; brute++){
			int[] arrow = new int[11];
			int score = 0;
			int left = n;
			for(int i = 0; i < 10; i++){
				if((brute & (1<<i)) != 0){
					score += (10-i);
					left -= (info[i]+1);
					arrow[i] = info[i]+1;
				}
				else if(info[i] != 0)
					score -= (10-i);
			}

			if(score <= 0 || left < 0) continue;
			arrow[10] = left;

			if(score > max){
				best = arrow;
				max = score;
			} else if (score == max) {
				if(isLowShot(arrow, best)) {
					best = arrow;
				}
			}
		}

		return max < 0 ? new int[]{-1} : best;
	}

	public static void main(String[] args) {
		Test4 a = new Test4();
		int[] b = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		System.out.println(a.solution(2, b));	
	}
}
