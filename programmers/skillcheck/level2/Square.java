package skillcheck.level2;

import java.math.BigInteger;

// 멀쩡한 사각형
// 최대 공약수를 구하는 문제

public class Square {

	static public long solution(long w, long h) {
		long totalCount = (long) w * (long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        System.out.print(BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue());
        return totalCount - diagonalCount;
    }

	public static void main(String[] args) {
		
		System.out.println(solution(8, 12));	
	}

}