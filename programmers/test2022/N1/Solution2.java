package programmers.test2022.N1;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int solution(String S) {
        if(S.length() < 2) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;

        for(int len = 2 ; len <= S.length(); len++) {
            for(int start = 0; start+len <= S.length(); start++) {
                Set<Character> set = new HashSet<>();
                for(int cur = start; cur <= start + len - 1; cur++) {
                    set.add(S.charAt(cur));
                }

                while(true) {
                    Character c = set.iterator().next();
                    boolean existsLowerCase = set.remove(Character.toLowerCase(c));
                    boolean existsUpperCase = set.remove(Character.toUpperCase(c));
                    if(!(existsUpperCase && existsLowerCase)) {
                        break;
                    }

                    if(set.isEmpty()) {
                        return len;
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution("AcZCbaBz"));
    }

}
