package skillcheck.level3;

// 2 x n 타일링
// 피보나치라는 걸 눈치 채고 적용해서 풀었음.
// 피보나치는 더하기라 연산중에 나머지로 바꿔줘도됨.
// https://deveric.tistory.com/61 이게 원리임..
// 이런 원리를 알아내고 점화식을 유추해낼 수 있어야 함.

public class TwoWidthTiling {

	public int solution(int n) {
        int answer = 1;
        int before = 1;
        
        for(int i=0; i<n-1; i++){
            int temp = answer;
            answer = (answer+before)%1000000007;
            before = temp;
        }
        
        return answer;
    }
}
