package skillcheck.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MenuRenewal {

    public void solution(String[] orders, int[] course) {
        ArrayList<HashMap<String, Integer>> freq = new ArrayList<>();

        for(int i = 0; i < 11; i++) {
            HashMap<String, Integer> tmp = new HashMap<>();
            freq.add(tmp);
        }

        // A. 코스 메뉴 조합 추출
        for(int t = 0; t < orders.length; t++) {
            char[] order = orders[t].toCharArray();
            Arrays.sort(order);

            for(int i = 1; i < (1 << order.length); i++) {
                String menu = "";
                int tmp = i;

                for(int j = 0; j < order.length; j++) {
                    if((i & (1 << j)) > 0) menu += order[j];
                }

                int cnt = freq.get(menu.length()).getOrDefault(menu, 0);
                freq.get(menu.length()).put(menu, cnt + 1);

            }
        }
    }
}
