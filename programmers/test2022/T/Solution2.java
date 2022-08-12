package programmers.test2022.T;

import java.util.Arrays;

public class Solution2 {

    public int solution(int[] levels) {
        int length = levels.length;
        int cutLine = length % 4 == 0 ?
                (length * 3 / 4) : (length * 3 / 4) + 1;

        Arrays.sort(levels);

        if(cutLine > length - 1) {
            return -1;
        }

        return levels[cutLine];
    }

    public static void main(String[] args) {

    }
}
