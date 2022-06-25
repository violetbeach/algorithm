
/*
* 거스름 돈
*
* 어려워서 이해를 잘 못했다.
*
* 1, 2, 5원으로 10원 동전을 만드는 경우의 수는
* 1, 2원으로 10원을 만드는 경우의수 + 1 2원으로 5원을 만드는 경우의 수이다.
*
* 점화식이 익숙하지 않아서 그런 것 같다.
* 너무 마음쓰지는 말고 많이 풀자!
* */

public class Change {

    public int solution(int n, int[] money) {
        int[] answer = new int[100001];
        answer[0] = 1;
        for(int coin: money) {
            for(int j = coin; j<= n; j++) {
                answer[j] += answer[j-coin];
            }
        }
        return answer[n];
    }

}
