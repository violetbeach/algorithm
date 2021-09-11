package basic.dfsbfs;

// 타겟 넘버
// 생소한 문제라서 쫄았는데, 일단 그래도 하는데까지 해보고 답지를 보자 라고 생각했는데, 다른 사람들의 풀이와 완전히 똑같이 해버렸다. 잘했다!
// 오랜만에 써보는 재귀의 파라미터에 대한 불신, 함수 위치에 대한 불신이 찼었는데 그거 마저 똑같으니까 신기하다.
// 다만 다른 사람 풀이는 i가 아니라 n을 썼다.. 그래.. i는 반복문에서만 쓰자.

public class TargetNumber {
	
	static int recursive(int[] numbers, int target, int sum, int i) {
		
		if(i == numbers.length) {
			if(sum == target) {
				return 1;
			}	
			return 0;
		}
		return recursive(numbers, target, sum - numbers[i], i+1) + recursive(numbers, target, sum + numbers[i], i+1);	
	}
	
	static int solution(int[] numbers, int target) {
        
        return recursive(numbers, target, 0, 0);
        
    }

	public static void main(String[] args) {

		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

}