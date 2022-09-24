package programmers.test2022.K;


import java.util.Arrays;

/*
* 1월쯤 해설 나올듯..
*
* 트리 계산하는 문제
*
* 딱 1분만 더있었으면 좋았을텐데.. 마지막에 변경한 알고리즘이 맞았을 수도 ? ㅠ
*
* 나중에 해설보거나, 오픈채팅 보고 다시 풀어보자.
*
* 많이 배웠다.
*
* */

public class Solution4 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, 1);
        for(int i = 0; i < numbers.length; i++) {
            if(isBad(numbers[i])) {
                answer[i] = 0;
            }
        }

        return answer;
    }

    boolean isBad(long num) {
        if(num % 2 == 0) return true;
        if (isEqualsReverse(Long.toBinaryString(num))) return true;

        return false;
    }

    private boolean isEqualsReverse(String binaryString) {
        while(binaryString.length() % 2 == 1 && binaryString.length() > 3) {
            char c = binaryString.charAt(binaryString.length() / 2);
            String left = binaryString.substring(0, binaryString.length() / 2);
            String right = binaryString.substring((binaryString.length() / 2) + 1);
            if(c == '0' && left.equals(right)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        long[] array = {5, 95};
        System.out.println(solution4.solution(array));
    }

}