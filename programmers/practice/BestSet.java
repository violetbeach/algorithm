import java.util.Arrays;

/*
* 최고의 집합
*
* 문제를 잘 읽자! 합이 맞아야 되고, 곱이 최대가 되어야 하면 어떻게 처리해야 되는지 계산할 수 있었다.
* 나머지로 부족한 숫자를 구할 수 있었다.
*
* 너무도 간단한 문제였는데, 못 풀었다 ㅠ ..
* */
public class BestSet {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] ans = new int[n];
        int value = s / n;
        int rest = s % n;

        for (int i = 0; i < n; i++) {
            ans[i] = value;
        }

        for (int i = 0; i < rest; i++) {
            ans[n-1-i]++;
        }

        return ans;
    }
}