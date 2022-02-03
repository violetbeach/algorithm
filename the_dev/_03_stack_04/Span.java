package the_dev._03_stack_04;


import java.util.Arrays;
import java.util.Stack;

public class Span {

    public static void main(String[] args) {
        Span span = new Span();
        System.out.println(Arrays.toString(span.solution(new int[]{5, 3, 2, 4, 7, 1})));
        System.out.println(Arrays.toString(span.solution(new int[]{2, 3, 4, 5, 6, 7})));
    }

    /**
     * TODO 주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
     *  스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.
     *  예) [5, 3, 2, 4, 7, 1]    =>   [1, 1, 1, 3, 5, 1]
     *  예) [2, 3, 4, 5, 6, 7]    =>   [1, 2, 3, 4, 5, 6]
     * @param price
     * @return
     */

    private int[] solution(int[] price) {
        int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return span;
    }

    // 수학 시간에 규칙찾는 것을 정말 좋아했지만 찾지 못했다.
    // 배운 점
    // 1. 알고리즘 공부는 유형을 파악하는 것이 거의 전부다. 코드 짜는 건 다른 얘기겠지만, 유형은 몇 개 없기 때문
    // 2. 그림을 그려야 한다. 숫자 예시 뿐만 아니라, 그림을 그리고 추가로 표까지 그리면 왠만하면 규칙이 나온다.
}
