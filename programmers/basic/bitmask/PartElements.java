package basic.bitmask;

import java.util.Arrays;

public class PartElements {
	public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, -1, -5};
        // 모든 부분집합의 경우의 수
        for (int i = 1; i < (1 << array.length); i++) {
            int[] temp = new int[array.length]; // 임시 부분 집합
            int count = 0; // 새로운 배열 크기
            boolean isOdd = true; // 홀수 여부 확인
            // 부분집합 생성
            for (int j = 0; j < array.length; j++) {
                if ((i & (1 << j)) != 0) {
                    if (array[j] % 2 == 0) {
                        isOdd = false;
                    }else{
                        temp[count++] = array[j];
                    }
                }
            }
            // 출력
            if (isOdd) System.out.println(Arrays.toString(Arrays.copyOf(temp,count)));
        }
    }
}
