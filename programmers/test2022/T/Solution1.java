package programmers.test2022.T;

import java.util.*;

public class Solution1 {

    private final String[] goodNumber = {
            "000",
            "111",
            "222",
            "333",
            "444",
            "555",
            "666",
            "777",
            "888",
            "999"
    };

    public int solution(String s) {
        for(int i = goodNumber.length - 1; i >= 0; i--) {
            if(s.contains(goodNumber[i])) {
                if(i == 0) {
                    return 0;
                }
                return Integer.parseInt(goodNumber[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
