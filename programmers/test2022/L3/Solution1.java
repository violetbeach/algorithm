package programmers.test2022.L3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1 {
    public int[] solution(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>(Arrays.stream(arr1).mapToObj(String::valueOf).collect(Collectors.toList()));

        int[] answer = new int[arr2.length];
        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < 6; j++) {
                StringBuilder temp = new StringBuilder(Integer.toString(arr2[i]));
                for(char k = '0'; k <= '9'; k++) {
                    temp.setCharAt(j, k);
                    if (temp.toString().equals(Integer.toString(arr2[i]))) {
                        continue;
                    }
                    if(set.contains(temp.toString())) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] s = {123457,123458,623456,123436,123456,223344,113344};
        int[] b = {123456,123344,223455};
        System.out.println(Arrays.toString(new Solution1().solution(s, b)));
    }

}
