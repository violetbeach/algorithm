package skillcheck.level3;

import java.util.Arrays;

/*
* 숫자 게임
*
* 어려운 문제가 아님에도 막혔다. 많이 풀자.
* */

public class NumberGame {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int aIndex = A.length - 1, bIndex = B.length - 1; bIndex >= 0 && aIndex >= 0; aIndex--) {
            if(B[bIndex] > A[aIndex]) {
                answer++;
                bIndex--;
            }
        }

        return answer;
    }

}
