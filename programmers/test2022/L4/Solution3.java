package programmers.test2022.L4;

public class Solution3 {

    public static final int defaultPower = 1;

    public long[][] solution(int n, int m, int[][] fires, int[][] ices) {
        long[][] answer = new long[n][n];

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                for(int i = 0; i < fires.length; i++) {
                    answer[row][col] += getFireEffect(col, row, fires[i][1] - 1, fires[i][0] - 1, m);
                }

                for(int i = 0; i < ices.length; i++) {
                    answer[row][col] += getIceEffect(col, row, ices[i][1] - 1, ices[i][0] - 1, m);
                }
            }
        }

        return answer;
    }

    int getFireEffect(int x, int y, int fireX, int fireY, int m) {
        int distance = Math.max(Math.abs(fireX - x), Math.abs(fireY - y));
        if(distance == 0) {
            return m;
        }
        return Math.max(m + defaultPower - distance, 0);
    }

    int getIceEffect(int x, int y, int iceX, int iceY, int m) {
        int iceDistance = Math.abs(iceX - x) + Math.abs(iceY - y);
        if(iceDistance == 0) {
            return - m;
        }
        return Math.min(0, - (m + defaultPower - iceDistance));
    }

    public static void main(String[] args) {

    }

}