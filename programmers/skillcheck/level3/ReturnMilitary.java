package skillcheck.level3;

/*
* 부대 복귀
*
* 플루이드 워샬
* 오랜만이었지만, 뇌를 굴려서 풀어냈다..! (뿌듯)
*
* 단, 실제 경로 수 보다 배열이 너무 컸다.
* 그래서 플루이드 워샬 형식으로 2중 for문 조차 사용해선 안되었다.
*
* -> 인접 행렬이 아니라 인접 리스트를 사용해서
*   1. 쓸데 없는 연산과 2. 메모리 낭비를 없애야만 통과가 가능했다.
*
* */

public class ReturnMilitary {

    static final int INF = 100_001;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }

        for(int[] road : roads) {{
            map[road[0]-1][road[1]-1] = 1;
            map[road[1]-1][road[0]-1] = 1;
        }}

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(map[destination - 1][j] > map[destination - 1][i] + map[i][j]) {
                    map[destination - 1][j] = map[destination - 1][i] + map[i][j];
                }

            }

        }

        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            answer[i] = map[destination - 1][sources[i] - 1] == INF ? -1: map[destination - 1][sources[i] - 1];
        }

        return answer;
    }

}
