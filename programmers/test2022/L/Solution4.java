package Line;

// 잘 풀었다.

public class Solution4 {
    public int solution(int[] arr, int[] brr) {
        int size = arr.length;

        int answer = 0;
        for(int i=0; i<size; i++) {
            if(arr[i] != brr[i]) {
                arr[i + 1] += arr[i] - brr[i];
                arr[i] = brr[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String[] a = {"1","2","4","3","3","4","1","5"};
        String[] b = {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};

    }
}
