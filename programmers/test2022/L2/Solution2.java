import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static int[] dp;

    public int solution(int n, int[] times) {
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dfs(1, times, n, 0);

        return dp[n];
    }

    public void dfs(int thread, int[] times, int n, int cost) {
        if(cost < dp[thread]) {
            dp[thread] = cost;
        } else {
            return;
        }

        for (int i = 1; i <= thread; i++) {
            if(thread + i <= n) {
                dfs(thread + i, times, n, cost + times[i-1]);
            }
        }

    }

    public static void main(String[] args) {
        int[] times = {2, 3};
        System.out.println(new Solution2().solution(4, times));
    }
}
