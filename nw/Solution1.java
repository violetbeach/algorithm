import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/*
* 라이브 코딩 인터뷰
*
* HashMap에서 넣은 순서를 보장해줄 수 있어야 한다면 LinkedHashMap을 사용할 수 있다.
*
* LinkedHashMap은 기본적으로 HashMap과 동일하게 동작하지만,
* double-linked List로 모든 Entry의 주소를 보관한다.
* 성능 차이는 미미하다.
* */

public class Solution1 {

    public String encrypt(String original) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(char c : original.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb
                    .append(entry.getKey())
                    .append(entry.getValue());
        }

        return sb.toString();
    }

    @Test
    void test() {
        Assertions.assertEquals("B2A3C1D1", encrypt("BABCADA"));
    }

}
