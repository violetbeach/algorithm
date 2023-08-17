/*
* 레오형님이 공유해주신 문제
*
* 알고리즘 고안도 어렵고 기발했지만
* 인덱스 지옥을 헤쳐나가기가 너무 어려웠다..
*
* 그래도 감사 👍
*
* */

public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] values = new int[n + 2];
		values[0] = 1;
		values[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
			values[i] = nums[i - 1];
		}

		n = values.length;
		int[][] dp = new int[n][n];
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = len + i - 1;
				for (int k = i + 1; k < j; k++) {
					dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
				}
			}
		}

		return dp[0][n - 1];
	}
}
