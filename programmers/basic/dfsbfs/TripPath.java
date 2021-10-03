package basic.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;


// 여행 경로
// 백트래킹으로 해결
// 어렵지만, 유용함. 특정 상황에 가장 적합하고 효율적임. 잘 익혀야함.

public class TripPath {
	public String[] solution(String[][] tickets) {
        ArrayList<String> list = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        backtracking("ICN", 0, "ICN", tickets, list, visited);
        Collections.sort(list);
        String[] result = list.get(0).split(" ");
        return result;
    }
    
    public void backtracking(String s, int idx, String result, String[][] tickets, ArrayList<String> list, boolean[] visited) {
        if(idx == tickets.length) {
            list.add(result);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(visited[i] == false && tickets[i][0].equals(s)) {
                visited[i] = true;
                backtracking(tickets[i][1], idx + 1, result + " " + tickets[i][1], tickets, list, visited);
                visited[i] = false;
            }
        }
    }
	
	public static void main(String[] args) {
		TripPath a = new TripPath();
		String[][] words = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};	
		System.out.println(a.solution(words));
	}
}
