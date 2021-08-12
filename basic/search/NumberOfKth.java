package basic.search;

import java.util.Arrays;

// K번째수
// 다른 사람들의 풀이랑 거의 일치하다.
// 다만 15번째 줄부터 18번째 줄, 잘린 배열을 만드는 과정에서 아래의 코드 한 줄이면 충분했다.
// int[] tempArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);

public class NumberOfKth {
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int[] tempArr = new int[commands[i][1] - commands[i][0] + 1];
        	for(int j=0; j<commands[i][1]-commands[i][0]+1; j++) {
        		tempArr[j] = array[commands[i][0] + j - 1];
        	}
        	Arrays.sort(tempArr);
        	answer[i] = tempArr[commands[i][2]-1];
        }
        
        return answer;
    }

	public static void main(String[] args) {

		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] com = {{2,5,3}, {4,4,1}, {1,7,3}};
		System.out.println(solution(arr,com));
	}

}
