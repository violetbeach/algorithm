package kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 보석 쇼핑
// brute force하면 효율성에 문제가 생기는데, 최적화 과정에서 필요한 과정을 놓치지 않으면서, 불필요한 과정을 쳐내는 것이 어렵다.

// 나는 완성된 것에서 왼쪽, 오른쪽 최대로 자른 거 / 오른쪽, 왼쪽 최대로 자른 거를 비교한 방법을 사용했는데,
// 왼쪽과 오른쪽이 조금씩만 잘리는 경우도 있었던 것 같다. 그래서 몇개 TC에서 통과하지 못했다.

// 큐를 사용하면 딱 필요한 만큼만 자르면서 전진할 수 있다. 그게 최선이었다.

public class JewelryShopping {
   public int[] solution(String[] gems) { 
	   Queue<String> q = new LinkedList<String>();
       HashSet<String> hs = new HashSet<String>();
       HashMap<String, Integer> hm = new HashMap<String, Integer>();
       int startPoint = 0;
       int length = Integer.MAX_VALUE;
       int start = 0;

       for (String gem : gems) {
           hs.add(gem);
       }

       for (String gem : gems) {
           q.add(gem);
           hm.put(gem, hm.getOrDefault(gem, 0) + 1);

           while (true) {
               String temp = q.peek();
               if (hm.get(temp) > 1) {
                   q.poll();
                   hm.put(temp, hm.get(temp) - 1);
                   startPoint++;
               } else {
                   break;
               }
           }

           if (hm.size() == hs.size() && length > q.size()) {
               length = q.size();
               start = startPoint;
           }
       }


       return new int[]{start + 1, start + length};
  }
   
   public static void main(String[] args) {
	   JewelryShopping a = new JewelryShopping();
	   String[] b = {"AA", "AB", "AC", "AA", "AC"};
		System.out.println(a.solution(b));	
	}
}
