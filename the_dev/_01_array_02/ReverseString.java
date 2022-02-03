package the_dev._01_array_02;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.solution1("Hello".toCharArray()));
    }

    /**
     * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     *  예) hello => olleh
     *  예) happy new year => reay wen yppah
     *
     * @param message
     * @return
     */

    // 풀이 느낀점 -> 굳이 StringBuilder를 이유가 없음 + 그냥 temp 이용해서 자리 바꿔주면, 공간복잡도 O(1)이 될 수 있었음. (그게 더 좋은 지는 모르겠음)
    private char[] solution1(char[] message) {
        StringBuilder sb = new StringBuilder();
        for(char c : message) {
            sb.insert(0, c);
        }
        return sb.toString().toCharArray();
    }

    /**
     * TODO 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     *  예) hello => olleh
     *  예) happy new year => reay wen yppah
     *
     * @param message
     * @return
     */
    private char[] solution(char[] message) {
        return message;
    }
}
