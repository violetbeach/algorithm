package basic.stackque;


// 주식 가격
// 스택 큐 문제였는데, 아무리 생각해도 머리로 쉽게 구상 가능해서 그냥 짰는데 가장 인기있는 코드였다.
// 아무래도 2중 반복문이라 O(n^2)라.. 실무에서는 효율적이지 않을 것 같아서 다른 사람들 스택으로 짠 코드 돌려봤는데
// 내껀 10초 초반이고, 스택이나 큐로 복잡하게 짠 사람들은 30초대다.. 뭐지?

public class StockPrice {

	static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length; i++) {
			
			int result = 0;
			
			for(int j=i+1; j<prices.length; j++) {
				result++;
				
				if(prices[j] < prices[i]) {
					break;
				}
				
			}
			
			answer[i] = result;
			
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] s = {1, 2, 3, 2, 3};
		System.out.println(solution(s));
		
	}
}
