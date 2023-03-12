package programmers.test2022.K;

import java.util.Arrays;

/*
* 택배 배달과 수거하기
*
* 해설을 보니 Stack을 사용했으면 더 좋았다고 한다.
* (이미 수거했던 곳을 또 안해도 되니까)
*
* 그리고 좋은 풆이보다 최악의 경우에 100배 느린 성능이 나왔다.
*
* 시간복잡도는 눈에 보이기는 비슷해보였다. (다소 처리가 복잡하지만, 5배면 이해가 되겠지만, 이해가 안된다.)
* 자세히 디버깅해보니 매번 맨뒤에서 닫시 체크해야한다.
*
* 그리고 수거랑 배달을 따로 순서를 계산해야 n동안 while에서 --해야 하는 일이 안생긴다.
* 가령! 배달할 차례는 100,000인데 수거할 차례는1이라고 가정해보자.
* 수거도 100,000에서 시작해서 count--을 계속 실행해야 한다.
* */


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
            int d = truck.delivery(i);
            int p = truck.pickup(i);

            i = Math.max(d, p) - 1;

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

        public int delivery(int i) {
            while(delivery > 0 && dSum > 0) {
                int deliveryCount = Math.min(deliveriesGlobal[i], delivery);
                delivery -= deliveryCount;
                deliveriesGlobal[i] -= deliveryCount;
                dSum -= deliveryCount;
                i--;
            }

            return i;
        }

        public int pickup(int i) {
            while(recycle < limit && pSum > 0) {
                int recycleCount = Math.min(pickupsGlobal[i], getSpace());
                recycle += recycleCount;
                pickupsGlobal[i] -= recycleCount;
                pSum -= recycleCount;
                i--;
            }

            return i;
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

        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        long answer = solution2.solution(cap, n, deliveries, pickups);
    }

}