package Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Comparable 조금 더 상세히 공부

public class Solution5 {
    public long solution(int[] abilities, int k) {
        List<Integer> list = (ArrayList<Integer>) Arrays.stream(abilities).boxed().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());

        List<Choice> choices = new ArrayList<>();

        for(int i = 0; i<list.size(); i+=2) {
            if(i + 1 != list.size()) {
                choices.add(new Choice(list.get(i), list.get(i + 1)));
            } else {
                choices.add(new Choice(list.get(i), 0));
            }
        }

        Collections.sort(choices);

        long answer = 0;
        for(int i = 0; i<choices.size(); i++) {
            if(k != 0) {
                answer += choices.get(i).first;
                k--;
            } else {
                answer += choices.get(i).second;
            }
        }

        return answer;
    }

    class Choice implements Comparable<Choice>{
        int first;
        int second;

        Choice(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Choice choice) {
            return (choice.first - choice.second) - (this.first - this.second);
        }

    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        int[] a = {7, 6, 8, 9, 10};
        System.out.println(solution.solution(a, 1));

    }
}
