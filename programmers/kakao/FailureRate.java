package kakao;

import java.util.Arrays;

// 실패율
// 이중 반복문을 쓸일은 거의 없는 것 같다. 어덯게든 방법을 찾자.
// 여기에서는 stage수와 실패자 수를 함께 돌리지말고
// 중심이되는 stage수에 실패자 수를 넣어주고 한 번만 돌렸다.
// 쓸모 없는 데이터 검색을 허용하는 테스트는 없다. 반드시 최적화 해야 한다.
// 정렬은 드럽게 오래걸리고, 가변길이라면 TC중에 분명 무시무시한 큰 크기의 정렬이 있다.

public class FailureRate {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] nStagePlayerCount = new int[N];
		Stage[] stageArray = new Stage[N];
		int challenger = stages.length;

		for(int stage : stages) {
			if(stage <= N) nStagePlayerCount[stage-1]++;
		}
		
		for(int i=1; i<=N; i++) {
			stageArray[i-1] = new Stage(i, (double) nStagePlayerCount[i-1] / challenger);
			challenger -= nStagePlayerCount[i-1];
		}
		
		Arrays.sort(stageArray);
		
		for(int i=0; i<N; i++) {
			answer[i] = stageArray[N-i-1].stage;
		}
		
		return answer;
    }
	
	class Stage implements Comparable<Stage> {
		int stage;
		double failRate;
		
		Stage(int stage, double failRate){
			this.stage = stage;
			this.failRate = failRate;
		}
		
		@Override
		public int compareTo(Stage s) {
			if(failRate > s.failRate) return 1;
			else if(failRate < s.failRate) return -1;
			else {
				if(stage < s.stage) return 1;
				else return -1;
			}
		}
	}

	public static void main(String[] args) {
		FailureRate a = new FailureRate();
		System.out.println(a.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));	
	}
}
