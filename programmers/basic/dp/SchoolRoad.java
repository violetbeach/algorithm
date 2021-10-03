package basic.dp;

import java.util.HashMap;
import java.util.Map;

public class SchoolRoad {
    private int min = Integer.MAX_VALUE;
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] waterRoads = new boolean[n][m];
        Map<Pair, Integer> hm = new HashMap<>();
        
        for(int[] puddle : puddles){
            waterRoads[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        findMinPath(waterRoads, 1, 1, 0, hm);
        findMinPath(waterRoads, 1, 0, 1, hm);
        
        return min;
    }
    
    public void findMinPath(boolean[][] waterRoads, int count, int x, int y, Map<Pair, Integer> hm) {
        
    	if(waterRoads[y][x]) return;
    	
    	if(x == waterRoads[0].length - 2 && y == waterRoads.length - 1 || x == waterRoads[0].length - 1 && y == waterRoads.length - 2){
            min = min < count ? min : count;
            return;
        }
        Pair pair = new Pair(x, y);
        if(hm.containsKey(pair)) {
        	int pairCount = hm.get(pair);
        	if(count >= pairCount) return;
        	else hm.put(pair, count);
        } else {
        	hm.put(pair, count);
        }
        
        for(int i=0; i<4; i++){
            if(x < waterRoads[0].length - 1) findMinPath(waterRoads, count+1, x+1, y, hm);
            if(x > 0) findMinPath(waterRoads, count+1, x-1, y, hm);
            if(y < waterRoads.length - 1) findMinPath(waterRoads, count+1, x, y+1, hm);
            if(y > 0) findMinPath(waterRoads, count+1, x, y-1, hm);
        }
    }
    
    class Pair{
    	int x;
    	int y;
    	
    	Pair(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    	
    	public boolean equals(Object o) {
    		Pair p = (Pair)o;
    		return p.x == x && p.y == y;
    	}
    	
    	public int hashCode() {
    		return new Integer(x).hashCode() * 31 + new Integer(y).hashCode();
    	}
    }
    
    public static void main(String[] args) {
    	SchoolRoad a = new SchoolRoad();
		int[][] b = {{2, 2}};
		System.out.println(a.solution(4, 3, b));	
	}
    
}
