package basic.graph;

// 순위
// 3중 반복문이 뇌로 잘 안돌아간다. 많이 익혀야 적용을 결심하고 구현할 수 있을듯.

public class Ranking {
	public int solution (int n, int[][] results){
	    boolean[][] game =  new boolean[n][n];
	    int answer = 0;
	    for(int i=0; i<results.length; i++){ game[results[i][0]-1][results[i][1]-1]=true; }

	    for(int i=0; i<n; i++){
	        for(int j=0; j<n; j++){
	            for(int k=0; k<n; k++){
	                if(game[j][i]&&game[i][k]){game[j][k]=true;}
	            }
	        }
	    }
	    
	    for(int i=0; i<n; i++){
	        int result=0;
	        for(int j=0; j<n; j++){
	            if(game[i][j] || game[j][i]){result++;}
	        }
	        if(result==n-1){answer++;}
	    }
	    return answer;
	}
	
	public static void main(String[] args) {
		Ranking a = new Ranking();
		int[][] b = {{1,2}, {2,3}, {3,4}};
		System.out.println(a.solution(4, b));	
	}

}
