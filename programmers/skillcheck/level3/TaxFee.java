package skillcheck.level3;

/*
* 합승 택시 요금
*
* 플루이드 알고리즘을 더 확실하게 이해하게 되었다.
*
* 다익스트라는 한번 지나친 노드 기준은 갱신하지 않는다.
* 플루이드는 다익스트라를 n번 돌린다고 생각하면 될 것 같다.
*
* 모든 a->b, b->c 거리를 더해서 a->c에도 넣어주면 된다.
* */

public class TaxFee {

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] node = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                node[i][j] = 2000001; //200 * 100000 + 1
            }
            node[i][i] = 0;
        }

        for(int i = 0; i < fares.length; i++) {
            node[fares[i][0]][fares[i][1]] = fares[i][2];
            node[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[j][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n + 1; i++) {
            min = Math.min(min, node[s][i] + node[i][a] + node[i][b]);
        }
        return min;
    }

}
