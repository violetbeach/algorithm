import java.util.PriorityQueue;

public class Solution3 {
    public int solution(int fuel, int[] powers, int[] distances) {
        PriorityQueue<Rocket> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.compare, o1.compare));

        for (int i = 0; i < powers.length; i++) {
            pq.add(new Rocket(distances[i], powers[i]));
        }

        while(fuel != 0) {
            if(pq.isEmpty()) {
                break;
            }
            Rocket modified = fill(pq.poll());
            pq.add(modified);
            fuel--;
        }

        double answer = Double.MIN_VALUE;
        for (Rocket rocket : pq) {
            if(rocket.compare > answer) answer = rocket.compare;
        }

        return (int) Math.ceil(answer);
    }

    public Rocket fill(Rocket rocket) {
        rocket.time += 1;
        rocket.distance -= rocket.speed + rocket.power / 2;
        rocket.speed += rocket.power;
        rocket.compare = rocket.time + (double) rocket.distance / rocket.speed;
        return rocket;
    }

    static class Rocket {
        int speed;
        int distance;
        double time;
        int power;
        double compare = Double.MAX_VALUE;

        public Rocket(int distance, int power) {
            this.distance = distance;
            this.power = power;
        }
    }

    public static void main(String[] args) {
        int fuel = 8;
        int[] powers = {20, 30};
        int[] distances = {750, 675};
        System.out.println(new Solution3().solution(fuel, powers, distances));
    }
}
