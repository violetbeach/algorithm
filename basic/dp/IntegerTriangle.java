package basic.dp;

public class IntegerTriangle {
	
	// 정수 삼각형
	// 조건문으로 처음이나 끝인지 확인해줬는데 처음 구현 끝 구현, 가운데 구현 하면 된다.
	// 조건을 필요없이 많이 돌았다.
	
	public int solution(int[][] triangle) {
        int len = triangle.length;
        
        for(int i=1; i<len; i++) {
        	for(int j=0; j<triangle[i].length; j++) {
        		if(j==0) triangle[i][j] = triangle[i][j] + triangle[i-1][j];
        		else if(j==i) triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
        		else triangle[i][j] = (triangle[i-1][j-1] > triangle[i-1][j]) ?
        			triangle[i][j] + triangle[i-1][j-1] : triangle[i][j] + triangle[i-1][j];
        	}
        }
        
        int max = 0;
        
        for(int i=0; i<len; i++) {
        	max = (triangle[len-1][i] > max) ? triangle[len-1][i] : max;
        }
        
        return max;
        
    }

	public static void main(String[] args) {
		IntegerTriangle a = new IntegerTriangle();
		int[][] b = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(a.solution(b));	
	}
}