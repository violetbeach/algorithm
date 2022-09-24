package programmers.test2022.L4;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int solution(int[][] queries) {
        int answer = 0;

        Map<Integer, Integer> createSizes = new HashMap<>();
        Map<Integer, Integer> curSizes = new HashMap<>();
        for(int i = 0; i < queries.length; i++) {
            Integer createSize = createSizes.getOrDefault(queries[i][0], 0);
            Integer curSize = curSizes.getOrDefault(queries[i][0], 0);
            if(createSize >= queries[i][1] + curSize) {
                curSizes.put(queries[i][0], curSize + queries[i][1]);
            } else {
                createSize = getArraySize(curSize + queries[i][1]);
                createSizes.put(queries[i][0], createSize);
                answer += curSize;
                curSizes.put(queries[i][0], curSize + queries[i][1]);
            }

        }
        return answer;
    }

    int getArraySize(int needSize) {
        int size = 1;

        while(size < needSize) {
            size *= 2;
        }

        return size;
    }

    public static void main(String[] args) {
        int[][] queries = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution(queries));
    }

}
