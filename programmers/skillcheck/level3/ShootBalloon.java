package skillcheck.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
* 풍선 터트리기
*
* - 왼쪽, 오른쪽 모두에 자신보다 작은 값이 있는 경우 => 남길 수 없음
* 위 규칙을 떠올릴 수 있어야 풀 수 있었다.
*
* 즉 풀이를 쉽게 설명하면
* 왼쪽, 오른쪽 모두에 자신보다 작은 값이 있는 원소일 경우 답을 1 더한다.
*
* 이것을 아주 효율적인 알고리즘으로 바꿔야 했다.
* 매우 어려웠다. 많이 풀어보자.
* */

public class ShootBalloon {

    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }

        int left = a[0];    // a의 왼쪽 끝
        int right = a[a.length - 1];    // a의 오른쪽 끝
        int ans = 2;

        for (int i = 1; i < a.length - 1; i++) {
            // 왼쪽 끝+1의 요소가 left보다 작으면 남길 수 있음
            if (a[i] < left) {
                left = a[i];
                ans++;
            }

            // 오른쪽 끝-1의 요소가 right보다 작으면 남길 수 있음
            if (a[a.length - 1 - i] < right) {
                right = a[a.length - 1 - i];
                ans++;
            }

            // left == right 면 중복된 답이 들어갔으므로 ans--
            if (left == right) {
                ans--;
                break;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, solution(new int[]{9, -1, -5}));
        Assertions.assertEquals(3, solution(new int[]{-10, 10, -20, 30, 40, -60}));
        Assertions.assertEquals(7, solution(new int[]{-16, 27, 65, -100, 58, -92, -71, -68, -61, -33}));
        Assertions.assertEquals(4, solution(new int[]{-10, -9, 8, 9}));
    }

}
