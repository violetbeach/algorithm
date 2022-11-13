public class Solution1 {

    public int solution(int[] A) {

        int answer = 0, count = -1, temp = 0;

        Integer speed = null;

        boolean isFirst = true;

        for(int num : A) {
            if(speed != null && speed != num - temp) {
                if(count >= 2) {
                    answer += getPeriods(count);;
                }
                count = 0;
            }
            if(!isFirst) {
                speed = num - temp;
            }

            isFirst = false;
            count++;
            temp = num;
        }

        if(count >= 3) {
            answer += getPeriods(count);
        }

        return answer;

    }

    int getPeriods(int count) {
        return count * (count - 1) / 2;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] test = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        System.out.println(solution1.solution(test));
    }

}
