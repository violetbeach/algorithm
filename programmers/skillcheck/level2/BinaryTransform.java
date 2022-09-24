package skillcheck.level2;

/*
* 이진 변환
*
* parseInt의 2번째 인자로 radix(n진법)을 사용할 수 있다.
* */

public class BinaryTransform {

    public int[] solution(String s) {
        int[] answer = new int[2];

        // Transform을 1번 실행
        int result = trasnform(s);
        int answer = 1;

        while(result != 1) {
            String binary = Integer.toBinaryString(result);
            result = trasnform(binary);
            answer++;
        }

        return answer;
    }

    private int trasnform(String s) {
        String str = s.replaceAll("0", "");
        return Integer.parseInt(str, 2);
    }

}
