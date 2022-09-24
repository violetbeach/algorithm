package programmers.test2022.K;

import java.util.Arrays;

public class Solution2 {

    static int[] deliveriesGlobal;
    static int[] pickupsGlobal;
    static int dSum;
    static int pSum;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        deliveriesGlobal = deliveries;
        pickupsGlobal = pickups;

        dSum = Arrays.stream(deliveriesGlobal).sum();
        pSum = Arrays.stream(pickupsGlobal).sum();
        Truck truck = new Truck(cap);

        truck.init();

        // 배달
        int distance = 0;
        int cur = n - 1;
        for(int i = cur; i >= 0;) {
            if(completeHouse(i)) {
                i--;
                continue;
            }
            distance = i + 1;
            truck.delivery(i);
            truck.pickup(i);

            answer += distance * 2L;

            truck.init();
        }

        return answer;
    }

    private boolean completeHouse(int i) {
        return deliveriesGlobal[i] == 0 & pickupsGlobal[i] == 0;
    }

    class Truck {
        int delivery;
        int recycle;
        int limit;

        public void init() {
            this.recycle = 0;
            this.delivery = Math.min(limit, dSum);
        }

        public void delivery(int i) {
            while(delivery > 0 && dSum > 0) {
                int deliveryCount = Math.min(deliveriesGlobal[i], delivery);
                delivery -= deliveryCount;
                deliveriesGlobal[i] -= deliveryCount;
                dSum -= deliveryCount;
                verify();
                i--;
            }
        }

        public void pickup(int i) {
            while(recycle < limit && pSum > 0) {
                int recycleCount = Math.min(pickupsGlobal[i], getSpace());
                recycle += recycleCount;
                pickupsGlobal[i] -= recycleCount;
                pSum -= recycleCount;
                verify();
                i--;
            }
        }

        public void verify() {
            if(limit < delivery + recycle) {
                throw new IllegalArgumentException();
            }
        }

        private int getSpace() {
            return limit - delivery - recycle;
        }


        public Truck(int limit) {
            this.limit = limit;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int cap = 5;
        int n = 1;
        int[] deliveries = {30};
        int[] pickups = {25};

        long answer = solution2.solution(cap, n, deliveries, pickups);
        System.out.println(answer);
    }

}