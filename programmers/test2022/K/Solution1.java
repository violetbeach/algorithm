package programmers.test2022.K;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Term> termMap = new HashMap<>();
        for(String s : terms) {
            String[] split = s.split(" ");
            termMap.put(split[0], new Term(Integer.parseInt(split[1])));
        }

        List<Integer> answer = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate parseToday = LocalDate.parse(today, format);
        for(int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            LocalDate createdAt = LocalDate.parse(split[0], format);
            Privacy privacy = new Privacy(createdAt, termMap.get(split[1]));

            LocalDate expiredAt = privacy.getExpired();
            if(expiredAt.isBefore(parseToday)) {
                answer.add(i + 1);
            }

        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public class Privacy {
        LocalDate createdAt;
        Term term;

        public Privacy(LocalDate createdAt, Term term) {
            this.createdAt = createdAt;
            this.term = term;
        }

        private LocalDate getExpired() {
            LocalDate expiredAt = createdAt.plusMonths(term.periodMonth);
            if(expiredAt.getDayOfMonth() != 1) {
                return expiredAt.minusDays(1);
            } else {
                expiredAt = expiredAt.minusMonths(1);
                return LocalDate.of(expiredAt.getYear(), expiredAt.getMonth(), 28);
            }
        }

    }

    public class Term {
        private int periodMonth;

        public Term(int periodMonth) {
            this.periodMonth = periodMonth;
        }
    }

}
