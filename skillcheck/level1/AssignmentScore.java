package skillcheck.level1;

// 레벨1...풀었는데 60줄이라... 다시 공부 했다...
// 동일한 반복문 여러개 나오면 의심을 해보자.
// 배열을 하나 또 만들 필요 없었다. 그냥 인덱스를 뒤집은걸 기준으로 점수를 구하면 됬다. 바로 결과값만 구해서 추가한다.

public class AssignmentScore {
	
	public static String solution(int[][] scores) {
		StringBuilder builder = new StringBuilder();
        for(int i=0; i<scores.length; i++) {
            int max = 0;
            int min = 101;
            int sum = 0;
            int divide = scores.length;
            for(int j=0; j<scores.length; j++) {
                int score = scores[j][i];
                if(i != j) {
                    if(score < min) {
                        min = score;
                    }
                    if(score > max) {
                        max = score;
                    }
                }
                sum += score;
            }
            if(scores[i][i] < min || scores[i][i] > max) {
                sum -= scores[i][i];
                divide--;
            }
            double score = (double) sum / divide;
            builder.append(score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : score >= 50 ? "D" : "F" );
        }
        return builder.toString();
    }

	public static void main(String[] args) {
		int[][] a = {{50, 90}, {50, 87}};
		System.out.println(solution(a));	
	}
	
	
}
