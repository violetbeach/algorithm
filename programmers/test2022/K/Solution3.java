package programmers.test2022.K;

public class Solution3 {

    static final double[] sales = new double[]{10, 20, 30, 40};
    int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        int[][] emoInfos = new int[emoticons.length][4];
        for(int i = 0; i < 4; i ++) {
            for(int j = 0; j < emoticons.length; j++) {
                emoInfos[j][i] = (int)(emoticons[j] * (100 - (double)sales[i]) / 100);
            }
        }

        dfs(users, emoInfos, 0, new int[users.length]);

        return answer;
    }

    void dfs(int[][] users, int[][] emoInfos, int index, int[] result) {

        if(index == emoInfos.length) {
            int count = 0;
            int sum = 0;
            for(int i = 0; i < result.length; i++) {
                if(result[i] >= users[i][1]) {
                    count++;
                } else {
                    sum += result[i];
                }
            }

            if(answer[0] < count) {
                answer[0] = count;
                answer[1] = sum;
            } else if(answer[0] == count) {
                answer[1] = Math.max(sum, answer[1]);
            }

            return;

        }

        for(int j = 0; j < 4; j++) {
            int[] newResult = result.clone();

            for(int k = 0; k < users.length; k++) {
                if(users[k][0] <= sales[j]) {
                    newResult[k] += emoInfos[index][j];
                }
            }
            dfs(users, emoInfos, index + 1, newResult);

        }

    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] result = solution3.solution(users, emoticons);
        System.out.println(result);
    }

}