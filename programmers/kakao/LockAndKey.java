package kakao;

// 자물쇠와 열쇠
// 행렬 90도 회전, Brute force

// 재귀함수에 4중 for문 나오길래 이건 아니다 싶어서 다른사람 풀이를 봤는데.... 풀이가 맞았다. ㅜㅜ
// 행과 열이 최대 20이라서, 4중이라 해봐야 20^4 =  16000 밖에 안된다. 그렇게 보니까 괜찮네..
// 값이 작으면 4중 for문도 답이 될 수 있는 것 같다.

// 다만, 재귀가 아니라 반복문으로 풀어나갈 수 있는 문제 였다.
// 그리고 실제로 배열을 계속 만들어서 값을 더할 필요가 없었음. 그냥 있는 것 처럼 비교하면 됬음.
// 어차피 인덱스 참조라 퍼포먼스 지장 없으니, 이렇게 배열이 초과되는 구조면 배열을 더 크게 만드는것도 좋을듯.

public class LockAndKey {
	public boolean solution(int[][] key, int[][] lock) {
    	int size = lock.length - 1;
    	
    	for(int d = 0 ; d < 4 ; ++d) {
    		int[][] rotatedKey = rotate(d, key);
    		int[][] paddedKey = padding(rotatedKey, size);
    		
    		for(int R = 0 ; R < paddedKey.length - size ; ++R) {
    			for(int C = 0 ; C < paddedKey[0].length - size ; ++C) {
    				boolean flag = true;

    				for(int r = 0 ; r < lock.length ; ++r) {
    					for(int c = 0 ; c < lock[0].length ; ++c) {
    						if(lock[r][c] == paddedKey[R + r][C + c]) flag = false;
    					}
    				}
    				
    				if(flag) return true;
    			}
    		}
    	}
    	
    	return false;
    }

    private int[][] padding(int[][] arr, int size) {
    	int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];
    	
    	for(int r = 0 ; r < arr.length ; ++r) {
    		for(int c = 0 ; c < arr[0].length ; ++c) {
    			result[r + size][c + size] = arr[r][c];
    		}
    	}

    	return result;
	}

	private int[][] rotate(int cnt, int[][] arr){
    	if(cnt == 0) return arr;
    	
    	int[][] result = null;
    	int[][] origin = copy(arr);
    	
    	for(int i = 0 ; i < cnt ; ++i) {
    		result = new int[arr.length][arr[0].length];

    		for(int r = 0 ; r < origin.length ; ++r) {
    			for(int c = 0 ; c < origin[0].length ; ++c) {
    				result[c][origin.length - 1 - r] = origin[r][c]; 
    			}
    		
    		}
    		origin = result;
    	}
    	
    	return result;
    }
    
    private int[][] copy(int[][] arr){
    	int[][] result = new int[arr.length][arr[0].length];
    	
    	for(int r = 0 ; r < arr.length ; ++r) {
    		for(int c = 0 ; c < arr[r].length ; ++c) {
    			result[r][c] = arr[r][c];
    		}
    	}
    	
    	return result;
    }
}
