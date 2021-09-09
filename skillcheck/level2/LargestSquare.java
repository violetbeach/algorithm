package skillcheck.level2;

// 가장 큰 정사각형
// DP라는 개념이 생소해서 O(n^4)로 풀었다가 다른사람 풀이를 참고해서 풀었다.
// 아래 코드가 굉장히 이상적인게 가독성이 너무 좋다.

// 저렇게 반복해서 로컬 변수를 선언하면 리소스 관리는 어떻게 하지 싶었지만 컴파일러가 알아서 해석해서 고쳐준다고 한다.

// 지금은 변수를 미리 선언하고 반복으로 초기화하는 것 보다 가장 작은 범위 내에서 변수를 선언과 초기화가 베스트라고 한다.

public class LargestSquare {
	public int solution(int [][]board) {
		int answer = 0;
        int[][] newBoard = new int[board.length+1][board[0].length+1];
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                newBoard[i+1][j+1] = board[i][j];
        
        int max = 0;
        
        for(int i=1; i<newBoard.length; i++){
            for(int j=1; j<newBoard[i].length; j++){
                if(newBoard[i][j] == 1){
                    int left = newBoard[i-1][j];
                    int up = newBoard[i][j-1];
                    int leftUp = newBoard[i-1][j-1];
                    int min = Math.min(left, Math.min(up, leftUp)); 
                    newBoard[i][j] = min+1;
                    max = Math.max(max, min+1);
                }
            }
        }
        answer = max * max;
        return answer;
    }

	public static void main(String[] args) {
		LargestSquare a = new LargestSquare();
		int[][] b = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(a.solution(b));	
	}

}
