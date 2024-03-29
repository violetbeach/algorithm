package basic.dp;

// 도둑질
// DP를 잘 익혀서 바로바로 나와야함.
// 기본적으로 반복문

public class Thievery {
	public int solution(int[] money) {
        int length = money.length;
        int[] dp =new int[length-1];
        int[] dp2= new int[length];
        
        dp[0]=money[0];
        dp[1]=money[0];
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<length-1;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
        }
        for(int i=2;i<length;i++){
            dp2[i]=Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }
        
        return Math.max(dp[length-2],dp2[length-1]);
    }
}
