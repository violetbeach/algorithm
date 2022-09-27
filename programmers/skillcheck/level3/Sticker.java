package skillcheck.level3;

import java.util.Arrays;

/*
* 스티커 모으기
*
* 2DP 문제였다. 많이 풀자
* */

public class Sticker {

    public int solution(int sticker[]) {
        int len = sticker.length;

        if(len == 1) return sticker[0];

        int[] dpOne = new int[len];
        int[] dpTwo = new int[len];

        dpOne[0] = sticker[0];
        dpOne[1] = sticker[0];

        dpTwo[0] = 0;
        dpTwo[1] = sticker[1];

        for(int i = 2; i < len; i++) {
            dpOne[i] = Math.max(dpOne[i-2] + sticker[i], dpOne[i-1]);
            dpTwo[i] = Math.max(dpTwo[i-2] + sticker[i], dpTwo[i-1]);
        }

        return Math.max(dpOne[len - 2], dpTwo[len - 1]);
    }

    public static void main(String[] args) {
        Sticker sticker = new Sticker();
        int solution = sticker.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
    }
}
