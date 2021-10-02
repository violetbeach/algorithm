package basic.heap;

import java.util.PriorityQueue;
import java.util.Collections;

class DualPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations){
            String[] str = op.split("\\s+");
            
            if(str[0].equals("I")) {
                minQ.offer(Integer.parseInt(str[1]));
                maxQ.offer(Integer.parseInt(str[1]));
            } else {
                if(str[1].equals("1")) {
                    minQ.remove(maxQ.poll());
                } else {
                    maxQ.remove(null);
                    maxQ.remove(minQ.poll());
                }
            }
        }
        
        int max = maxQ.isEmpty() ? 0 : maxQ.poll();
        int min = minQ.isEmpty() ? 0 : minQ.poll();
        
        int[] maxAndMin = {max, min};
        
        return maxAndMin;
    }
}