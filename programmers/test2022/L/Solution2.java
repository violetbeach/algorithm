package Line;

import java.util.*;

// 조합을 사용한 것은 좋았다.
// 하나씩 add 하지 말고 Set을 미리 전부 만든 후에 교집합, 합집합을 구했으면, 코드도 간결해지고 시간복잡도를 줄일 수 있었다. (add를 너무 탐색 용도로 사용했다.)
// set.retainAll();
// set.addAll();

/*
10.000 calls: 125ms vs. 203ms
250.000 calls: 1077ms vs. 4508ms
1.000.000 calls: 4009ms vs. 18079ms
*/

class Solution2 {

    int maxScore = 0;

    public int solution(String[] sentences, int n) {
        Set<String> set = new HashSet<>();

        recursive(0, set, sentences, 0, n);

        return maxScore;
    }

    public void recursive(int idx, Set<String> set, String[] sentences, int score, int max) {
        Set<String> localSet = new HashSet<>(set);
        int localScore = score;

        for(String s : sentences[idx].split("")) {
            if(!s.equals(" ")) {
                localSet.add(s.toUpperCase());
            }
            localScore++;
            if(Character.isUpperCase(s.charAt(0))) {
                localSet.add("shift");
                localScore++;
            }
        }

        if(localSet.size() > max) {
            return;
        }

        if(maxScore < localScore) {
            maxScore = localScore;
        }

        if(idx != sentences.length - 1) {
            recursive(idx + 1, set, sentences, score, max);
            recursive(idx + 1, localSet, sentences, localScore, max);
        }

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] str = {"line in line", "LINE", "in lion"};
        System.out.println(solution.solution(str, 5));

    }
}