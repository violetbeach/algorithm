package skillcheck.level3;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 두 큐 합 같게 만들기
*
* 그리디 (규칙을 찾는 것이 중요)
*
* Queue는 구현체로 LinkedList보다 ArrayDeque가 성능상 좋다고 한다.
* */

public class DoubleQueue {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();

        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            que1.offer(queue1[i]);
        }

        for(int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            que2.offer(queue2[i]);
        }


        int count = 0;
        while(sum1 != sum2) {
            count++;

            if(sum1 > sum2) {
                int value = que1.poll();
                sum1 -= value;
                sum2 += value;
                que2.offer(value);
            } else {
                int value = que2.poll();
                sum1 += value;
                sum2 -= value;
                que1.offer(value);
            }

            if(count > (queue1.length + queue2.length) * 2) return -1;
        }


        return count;
    }

}
