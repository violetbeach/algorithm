package skillcheck.level2;

// 삼각 달팽이
// 2차원 행렬문제도 로직을 구현하기가 어렵다.. 기본기지만 도움이 되었어.

public class TriangleSnail {
	public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = 0, y = -1;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 	
                if (i % 3 == 0) {
                    y++;
                } else if (i % 3 == 1) {
                    x++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[y][x] = num++;
            }
        }
        
        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}
