package kakao;

import java.util.Stack;

// 프로그래머스 카카오프렌즈 컬러링북 문제
// bfs, dfs 둘다 생각했는데 뭘 하든 비효율적이라고 생각했는데 역시나.. 
// bfs가 그런데 조금 나을 것 같다는 감에서 했는데 dfs랑 똑같다.
// 재귀함수 돌릴때 반드시 파라미터 정적으로 올릴 수 있으면 올리는 것이 훨씬 빠르다. (예를 들면 돌릴 크기 같은 것)

// 그리고 큐 add랑 offer랑 비교해봤는데 속도 차이는 없다. 거의 똑같다.

public class ColoringBook {

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
                    numberOfArea += 1;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int bfs(int x, int y, int[][] picture) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y, picture[x][y]});
        visited[x][y] = true;
        int areaSize = 1;

        while (!stack.isEmpty()) {
            int[] now = stack.pop();
            int cx = now[0];
            int cy = now[1];
            int curColor = now[2];

            for(int i = 0; i < 4; i++) {
                int tx = cx + dx[i];
                int ty = cy + dy[i];

                // 사진 밖으로 나가는 경우
                if(tx < 0 || tx >= picture.length || ty < 0 || ty >= picture[tx].length) continue;

                // 같은 색상 && 미방문인 경우
                if(picture[tx][ty] == curColor && !visited[tx][ty]) {
                    // 방문 처리
                    visited[tx][ty] = true;
                    stack.push(new int[]{tx, ty, picture[tx][ty]});
                    areaSize += 1;
                }
            }
        }
        return areaSize;
    }
	
	public static void main(String[] args) {
		ColoringBook a = new ColoringBook();
		int m = 6;
		int n = 4;
		int[][] picture = {
				{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{0,0,0,0},
				{0,0,0,0}};
		System.out.println(a.solution(m, n, picture));	
	}

}
