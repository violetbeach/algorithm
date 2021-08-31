package basic.stackque;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나가는 트럭
// 로직 구현하다가, 누구도 알아 볼 수 없는 코드를 짰다.. 아래는 훌륭한 분들의 객체 지향적인 코드다..
// 자바 개발자가 된 이상, 현실적인 관점으로 바라보자.

public class Truck {
	
	static class T {
        int weight;
        int move;

        public T(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

	static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<T> waitQ = new LinkedList<>();
        Queue<T> moveQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new T(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                T t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (T t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                T t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                T t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
	
	public static void main(String[] args) {

		int a = 2;
		int b = 10;
		int[] c = {7, 4, 5, 6};
		System.out.println(solution(a, b, c));

	}

}
