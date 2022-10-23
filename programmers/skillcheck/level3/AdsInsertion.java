package skillcheck.level3;

/*
* 광고 삽입
*
* 전형적인 prefixSum(+ 배열 - 변화량) 문제다. 경험이 부족했다. (투 포인터도 가능하다.)
* +배열을 순회할 때 뒷 원소를 빼고 앞 원소를 더하면서 순회하면 O(n)을 O(1)로 만들 수 있었다.
*
* 시간복잡도를 잘 계산해야 한다.
*
* */

public class AdsInsertion {

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSecond(play_time);
        int advTime = timeToSecond(adv_time);
        int[] total = new int[playTime + 1];

        for (String log : logs) {
            String[] arr = log.split("-");

            int start = timeToSecond(arr[0]);
            int end = timeToSecond(arr[1]);

            //종료 시점은 보지 않음으로 부등호(<)
            for (int j = start; j < end; j++) {
                total[j]++;
            }
        }

        //logs가 30만개이기 때문에 int를 사용할 시 범위 초과
        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += total[i];
        }

        long max = sum;
        int start = 0;
        for (int i = 1, j = advTime; j < playTime; i++, j++) {
            sum += total[j] - total[i - 1];

            if (max < sum) {
                max = sum;
                start = i;
            }
        }

        return secondToTime(start);
    }

    int timeToSecond(String time) {
        int second = 0;
        String[] arr = time.split(":");

        second += Integer.parseInt(arr[0]) * 3600;
        second += Integer.parseInt(arr[1]) * 60;
        second += Integer.parseInt(arr[2]);

        return second;
    }

    String secondToTime(int second) {
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i >= 0; i--) {
            int t = second / (int) Math.pow(60, i);
            second %= (int) Math.pow(60, i);

            if (t < 10) {
                sb.append(0).append(t);
            } else {
                sb.append(t);
            }

            if (i != 0)
                sb.append(":");
        }

        return sb.toString();
    }

}
