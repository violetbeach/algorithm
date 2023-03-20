package programmers.test2022.K;


/*
 * 표현 가능한 이진트리
 *
 * 정말 어려웠다 ㅠ-ㅠ
 *
 * 배열로 트리를 구성할 수 있어야 했고, 트리의 서브트리(왼쪽, 오른쪽)을 구할 수 있어야 했다.
 *
 * 비교문 및 조건문을 꼼꼼하게 짜도록 노력하자. (과하지도, 부족하지도 않게 꼼꼼히.. 시간 많이 투자하자)
 *
 * 정말 오래걸렸고, 삽질도 많았지만 결과물은 좋다. 기억하자.
 * *
 * */

class Solution4 {

    static int[] answer;

    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            StringBuilder sb = new StringBuilder(Long.toBinaryString(numbers[i]));
            int sLen = sb.length();

            // 완전 포화 트리를 위해 앞에 0 삽입
            int j = 1;
            while(j - 1 < sLen) j *= 2;
            for(int k = 0; k < j - sLen - 1; k++) {
                sb.insert(0, "0");
            }

            if(dfs(sb.toString())) answer[i] = 1;

        }
        return answer;
    }

    boolean dfs(String n) {
        int mid = n.length() / 2;

        String left = n.substring(0, mid);
        String right = n.substring(mid + 1, n.length());

        if(n.length() == 1) return true;

        if(n.charAt(mid) == '0' && (left.charAt(mid/2) == '1' || right.charAt(mid/2) == '1')) {
            return false;
        }

        return dfs(left) && dfs(right);

    }

}