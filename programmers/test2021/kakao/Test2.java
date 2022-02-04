package programmers.test2021.kakao;

// k진수에서 소수 개수 구하기
// # 취준생 당시 코테 풀었던 것 복기

// answer변수 같은 것들을 함수 시작에 무지성으로 작성하지말고, 사용하기 직전에 선언해서 메모리를 safe 하자!
// 소수검사를 절차적으로 작성하니까 isPrime변수가 필요해졌고, 코드가 가독성이 안좋아졌다. 함수를 따로 선언하자!

// for문에서 itar를 long으로 맞춰주니까, 효율이 낭비됬다. 비교 대상을 sqrt로 처리하면 됬었다. 비교 대상은 한번만 선언되기 때문

public class Test2 {

	public int solution(int n, int k) {
		int answer = 0;

		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.insert(0, n % k);
			n = n / k;
		}

		for(String sub : sb.toString().split("0+")) {
			long num = Long.parseLong(sub);
			if(num == 1) continue;
			if(isPrime(num)) answer++;
		}

		return answer;
	}

	public boolean isPrime(long number) {
		if(number < 2) return false;
		if(number == 2) return true;
		for(int i = 2; i <= (int) Math.sqrt(number); i++) {
			if(number % i == 0)  return false;
		}
		return true;
	}

	/*public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
        	sb.insert(0, n % k);
        	n = n / k;
        }

		int answer = 0;
        for(String sub : sb.toString().split("0+")) {
        	long num = Long.parseLong(sub);	
        	if(num == 1) continue;
        	for(long i=2; (long)i*i<=num; i++) {
        		if((long)num % i == 0) {
        			continue;
        		}
        	}
        	answer++;
        }
        
        return answer;
    }*/

	public static void main(String[] args) {
		Test2 a = new Test2();
		System.out.println(a.solution(3, 6));	
	}
}
