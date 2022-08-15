package programmers.test2022.N1;

public class Solution1 {

    public int solution(int[] A) {
        int continueCount = 0;
        int cur = 0;
        int answer = 0;
        for(int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i-1];
            if(diff == cur) {
                continueCount++;
            } else {
                cur = diff;
                answer += calc(continueCount);
                continueCount = 1;
            }

            if(i == A.length - 1) {
                answer += calc(continueCount);
            }

            if(answer > 1000000000) {
                return -1;
            }

        }
        return answer;
    }

    private int calc(int continueCount) {
        int total = 0;
        if(continueCount >= 2) {
            total += Math.pow(2, continueCount -1) - 1;
        }
        return total;
    }

    public static void main(String[] args) {

    }
}