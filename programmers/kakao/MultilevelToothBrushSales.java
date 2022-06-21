package kakao;

import java.util.*;

/*
* 카카오 - 다단계 칫솔 판매
*
* 아주아주 잘짰다. 성능 만점이고 구현도 잘했다.
* 다만 길이가 sell(0)을 부모가 계속 호출하는 문제가 발생했다. 실전이라면 break point를 반드시 추가해줬어야했다.
*
* ps. 맥북 사자. 단축키 너무 화나고 눈 빠지겠다. 그냥 사자 좀!!!!!!!!
* */

public class MultilevelToothBrushSales {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int length = enroll.length;
        int sellLength = seller.length;

        Map<String, Seller> map = new HashMap<>();
        List<Seller> list = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            Seller newSeller = new Seller(0);
            map.put(enroll[i], newSeller);
            list.add(newSeller);
        }

        for(int i = 0; i < length; i++) {
            map.get(enroll[i]).connect(map.get(referral[i]));
        }

        for(int i = 0; i < sellLength; i++) {
            map.get(seller[i]).sell(100 * amount[i]);
        }
        return list.stream().map(v -> v.money).mapToInt(Integer::intValue).toArray();
    }

    public class Seller {
        private Seller supSeller;
        private int money;

        public Seller(int money) {
            this.money = money;
        }

        public void connect(Seller supSeller) {
            this.supSeller = supSeller;
        }

        public void sell(int price) {
            int bonus = price * 1/10;
            this.money += price - bonus;
            if(this.supSeller != null && bonus > 0) {
                supSeller.sell(bonus);
            }
        }
    }
}
