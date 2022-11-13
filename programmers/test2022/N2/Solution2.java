import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    char lowerBase = 'a';
    char upperBase = 'A';

    public int solution(String S) {
        int[] lowers = new int[26];
        int[] uppers = new int[26];

        int answer = -1;

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLowerCase(c)) {
                int alpha = c - lowerBase;
                lowers[alpha]++;
            } else {
                int alpha = c - upperBase;
                uppers[alpha]++;
            }

            for(int k = 0; k < 26; k++) {
                if(lowers[k] > 0 && uppers[k] == 0) {
                    break;
                }
                if(lowers[k] == 0 && uppers[k] > 0) {
                    break;
                }

                if(k == 25) {
                    answer = Math.max(i + 1, answer);
                }
            }

            int[] lowers2 = new int[26];
            int[] uppers2 = new int[26];
            for(int j = 0; j < S.length(); j++) {
                char c2 = S.charAt(j);
                if(Character.isLowerCase(c2)) {
                    int alpha = c2 - lowerBase;
                    lowers2[alpha]++;
                } else {
                    int alpha = c2 - upperBase;
                    uppers2[alpha]++;
                }

                if(j <= i) {
                    continue;
                }

                int[] tempLower = new int[26];
                int[] tempUpper = new int[26];

                for(int k = 0; k < 26; k++) {
                    tempLower[k] = lowers2[k] - lowers[k];
                    tempUpper[k] = uppers2[k] - uppers[k];
                    if(tempLower[k] > 0 && tempUpper[k] == 0) {
                        break;
                    }
                    if(tempLower[k] == 0 && tempUpper[k] > 0) {
                        break;
                    }

                    if(k == 25) {
                        answer = Math.max(j - i, answer);
                    }
                }
            }

        }

        return answer;

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution("azABaabza"));
    }

}
