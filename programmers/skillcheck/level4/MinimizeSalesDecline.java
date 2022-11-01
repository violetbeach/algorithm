
import java.util.ArrayList;
import java.util.List;

/*
* 매출 하락 최소화
*
* 마지막 문제이면서 레벨도 4이지만 코드가 그렇게 길지 않다.
* 사용할 자료구조의 특성과 문제의 규칙을 잘 이용하면 간단한 식을 세워서 어렵지 않게 풀이가 가능했다.
* */

class MinimizeSalesDecline {

    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        int dp[][] = new int[n + 1][2];
        List<Integer> link[] = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = new ArrayList<>();
        }
        for (int i = 0; i < links.length; i++) {
            int upper = links[i][0];
            int lower = links[i][1];
            link[upper].add(lower);
        }

        dfs(1, dp, sales, link);

        return Math.min(dp[1][0], dp[1][1]);
    }

    public void dfs(int current, int[][] dp, int[] sales, List<Integer> link[]) {
        dp[current][1] = sales[current - 1];

        if (link[current].size() != 0) {
            for (int next : link[current]) {
                dfs(next, dp, sales, link);
            }

            int min_val = Integer.MAX_VALUE;
            for (int next : link[current]) {
                if (dp[next][0] < dp[next][1]) {
                    dp[current][0] += dp[next][0];
                    dp[current][1] += dp[next][0];
                    min_val = Math.min(min_val, dp[next][1] - dp[next][0]);
                } else {
                    dp[current][0] += dp[next][1];
                    dp[current][1] += dp[next][1];
                    min_val = 0;
                }
            }
            if (min_val != Integer.MAX_VALUE) {// 모든 자식노드가 참가하지 않았다면 최소비용을 더해 강제로 하나의 팀을 참여시킴
                dp[current][0] += min_val;
            }
        }
    }
}
