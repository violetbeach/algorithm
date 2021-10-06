package basic.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

// 메뉴 리뉴얼
// 조합할 때, 해시에서 EntrySet꺼내는 것 중요
// 어렵다.

public class MenuRenewal {
	public ArrayList<String> solution(String[] orders, int[] course) {
        HashMap<String,Integer> map;
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        for(int i =0;i<course.length;i++){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;   
            for(int j =0;j<orders.length;j++){
                StringBuilder sb = new StringBuilder(); 
                if(course[i]<=orders[j].length())
                    combi(orders[j],sb,0,0,course[i], map);                               
            }
            
            for(Entry<String,Integer> entry : map.entrySet()){
                    max = Math.max(max,entry.getValue());
                   
            }
            for(Entry<String,Integer> entry : map.entrySet()){
                    if(max >=2 && entry.getValue() == max)
                        answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        
        return answer;
    }
    
    public void combi(String str,StringBuilder sb,int idx, int cnt, int n, HashMap<String, Integer> map){
       if(cnt == n) {
           map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
           return;
        }
        
        for(int i = idx ; i<str.length();i++){
            sb.append(str.charAt(i));
            combi(str,sb,i+1,cnt+1,n, map);
            sb.deleteCharAt(cnt);
        }
    }
}
