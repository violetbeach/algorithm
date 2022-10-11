package skillcheck.level3;

/*
* 코딩 테스트 공부
*
* 코드를 깔끔하게 짜는 버릇을 알고리즘에서는 버려야 할 듯 하다.
*
* 복잡한 알고리즘을 코드까지 예쁘게 짜려면 어마무시하게 많은 노력과 시간이 소모된다.
* 
* */

public class CodingTestStudy {

    public int solution(int alp, int cop, int[][] problems) {

        int targetAlgo=0;
        int targetCode=0;
        //목표치를 구하는 for문
        for(int i =0; i<problems.length;i++){
            targetAlgo=Math.max(problems[i][0],targetAlgo);
            targetCode=Math.max(problems[i][1],targetCode);
        }

        if(targetAlgo<=alp&&targetCode<=cop){
            return 0;
        }

        if(alp>=targetAlgo){
            alp=targetAlgo;
        }
        if(cop>=targetCode){
            cop=targetCode;
        }

        int[][] dp =new int[targetAlgo+2][targetCode+2];

        for(int i=alp;i<=targetAlgo;i++){
            for(int j=cop;j<=targetCode;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        dp[alp][cop]=0;

        for(int i=alp;i<=targetAlgo;i++){
            for(int j=cop;j<=targetCode;j++){

                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);

                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);

                for(int[] p :problems){

                    if(i>=p[0]&&j>=p[1]){
                        if(i+p[2]>targetAlgo&&j+p[3]>targetCode){
                            dp[targetAlgo][targetCode]=Math.min(dp[targetAlgo][targetCode],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]>targetAlgo){
                            dp[targetAlgo][j+p[3]]=Math.min(dp[targetAlgo][j+p[3]],dp[i][j]+p[4]);
                        }
                        else if(j+p[3]>targetCode){
                            dp[i+p[2]][targetCode]=Math.min(dp[i+p[2]][targetCode],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]<=targetAlgo&&j+p[3]<=targetCode){
                            dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                        }
                    }

                }
            }
        }

        return dp[targetAlgo][targetCode];
    }

}
