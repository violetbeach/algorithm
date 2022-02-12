package programmers.test2021.kakao;

// 파괴되지 않은 건물
// # 취준생 당시 코테 풀었던 것 복기

// 너무... 재밌다!!
// 다른사람 풀이를 보고 동작을 생각하면서 그 기발한 알고리즘이 너무 신기했다.

// 테스트 당시 누적합을 경험해보지 못해서 구현을 하지 못했고 효율성을 만족시키지 못했다.
// 이런건 유형이라서 다양하게 풀어보고 유형을 넓히는게 도움이 될 것 같다.

public class Test6 {

	public int solution(int[][] board, int[][] skill) {
		int m=board.length, n=board[0].length, ret=0;
		int[][] sum = new int[m+1][n+1];
		for(int[] s : skill) {
			int i1=s[1],j1=s[2];
			int i2=s[3],j2=s[4];
			int d=s[5]*(s[0]==1?-1:1);
			sum[i1][j1] += d;
			sum[i2+1][j1] += d*-1;
			sum[i1][j2+1] += d*-1;
			sum[i2+1][j2+1] += d;
		}
		// 좌->우
		for(int j=1 ; j<n ; j++) {
			for(int i=0 ; i<m ; i++) {
				sum[i][j] += sum[i][j-1];
			}
		}
		// 상->하
		for(int i=1; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				sum[i][j] += sum[i-1][j];
			}
		}
		// 누적합
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(board[i][j]+sum[i][j]>0) ret++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Test6 a = new Test6();
		int[][] board = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		System.out.println(a.solution(board,skill));	
	}
}
