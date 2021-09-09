package skillcheck.level2;

// 최댓값과 최솟값

// 속도 비교
// 삼항 연산자 << if 문 <<<<<< Math.max / min 함수
// Max, Min 함수 쓰지말자.. 가독성이 그렇게 차이나는 것도 아니니까..

// 이랑 비슷하게 String.valueOf , toString 등도 많이 잡아먹는다. 그걸 + 연산하면 무지막지한 쓰레기 성능이 나온다.
// 더하는거는 그냥 무 조 건 Builder나 Buffer로 하자. 어차피 간단한 String + 연산해도 내부적으로 생성한다.


public class MaxAndMin {
	public String solution(String s) {
        String[] str = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<str.length; i++) {
        	int num = Integer.parseInt(str[i]);
        	if(min > num) min = num;
        	if(max < num) max = num;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }

	public static void main(String[] args) {
		MaxAndMin a = new MaxAndMin();
		System.out.println(a.solution("1 2 3 4"));	
	}
}
