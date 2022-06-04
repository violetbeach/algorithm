package programmers.test2022.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        recursive(answer, arr);
        return answer.stream().mapToInt(v->v).toArray();
    }

    public void recursive(List<Integer> answer, int[] arr) {
        int length = arr.length;
        // 1. arr의 길이가 1이라면, arr을 그냥 그대로 두고 과정을 종료합니다.
        if(length == 1) {
            answer.add(arr[0]);
            return;
        }

        // 2. arr을 앞뒤로 뒤집습니다.
        int[] reverseArr = new int[length];
        for(int i = 0; i < length; i++) {
            reverseArr[i] = arr[length - 1 - i];
        }

        // 3. arr의 길이가 짝수(2k)라면, 앞뒤로 길이가 k, k인 두 배열로 나눕니다.
        //    arr의 길이가 홀수(2k+1)라면, 앞뒤로 길이가 k+1, k인 두 배열로 나눕니다.
        int half = arr.length % 2 == 0 ? length / 2 : length / 2 + 1;
        recursive(answer, Arrays.copyOfRange(reverseArr, 0, half));
        recursive(answer, Arrays.copyOfRange(reverseArr, half, length));
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new Solution2().solution(s)));
    }
}
