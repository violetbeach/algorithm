package basic.dfsbfs;

// 네트워크
// 어렵다.. 재귀를 사용한다는 것을 알고, 불리안 배열을 만들어야 한다는 것 까지 생각했지만,
// 로직을 구현하지 못했다... 어디가서 머리 좋다는 소리 하지말고, 겸손하게 공부하자. 그리고 최고가 되자.


public class Network {

	static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] check = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			computers[i][i] = 0;
		}

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				dfs(computers, i, check);
				answer++;
	        }
	    }

		return answer;
	}

	static boolean[] dfs(int[][] computers, int i, boolean[] check) {
		check[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (computers[i][j] == 1 && check[j] == false) {
	        check = dfs(computers, j, check);
	        }
	    }
	    return check;
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, numbers));
	}

}
