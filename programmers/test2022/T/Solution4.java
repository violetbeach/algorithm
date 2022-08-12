package programmers.test2022.T;

import java.util.*;

public class Solution4 {

    public long[] solution(long[][] invitationPairs) {
        List<User> users = new ArrayList<>();

        for(int i = 0; i < invitationPairs.length; i++) {
            long diff = (invitationPairs[i][1] - users.size());
            for(int tmp = 0; tmp < diff; tmp++) {
                users.add(new User(users.size()));
            }

            Set<User> guests = users.get((int) invitationPairs[i][0]).getGuests();
            guests.add(users.get((int) invitationPairs[i][1] - 1));
        }

        Collections.sort(users);

        long[] answer = new long[3];
        answer[0] = users.get(0).id;
        answer[1] = users.get(1).id;
        answer[1] = users.get(2).id;

        return answer;
    }

    private static class User implements Comparable {
        private long id;
        private Set<User> guests;

        public User(long id) {
            this.id = id;
            this.guests = new HashSet<>();
        }

        @Override
        public int compareTo(Object o) {
            User to = (User) o;
            return -Long.compare(this.getPoint(), to.getPoint());
        }

        public long getPoint() {
            long point = 0;
            // 1
            point += this.guests.size() * 10L;

            // 2
            for(User guest : guests) {
                point += guest.getGuests().size() * 3L;

                // 3
                for(User leaf : guest.getGuests()) {
                    point += guest.getGuests().size();
                }
            }

            return point;
        }

        public Set<User> getGuests() {
            return guests;
        }
    }

    public static void main(String[] args) {
        long[][] test = {
                {1, 2},
                {3, 4}
        };
        Solution4 sol = new Solution4();
        System.out.println(sol.solution(test));
    }
}
