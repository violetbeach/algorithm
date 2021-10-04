package skillcheck.level2;

// 다음 큰 숫자
// Integer.bitCount 하면 1비트 수 구할 수 있음.

public class NextBigNumber {
	public int solution(int n) {
        
		int a = Integer.bitCount(n);
		int compare = n+1;

		while(true) {
			if(Integer.bitCount(compare)==a) break;
			compare++;
		}

		return compare;
        
    }
}