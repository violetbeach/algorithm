package twopointer;

import java.util.*;

class EnglishStudy
{

    static boolean[] visit;
    static int N, P, max;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N=sc.nextInt();
            P=sc.nextInt();
            int[] input=new int[N];
            for(int i=0;i<N;i++) input[i]=sc.nextInt();
            visit=new boolean[1000001];
            max=P+1;
            for(int day:input) visit[day]=true;

            search();
            System.out.println("#"+test_case+" "+max);
        }
    }
    public static void search() {
        int start=1;
        int end=1;
        int cnt=0;
        while(end<visit.length) {
            if(visit[end]) {
                cnt++;
                end++;
                max=Math.max(max, cnt);
            }
            else {
                if(P==0) {
                    max=Math.max(max, cnt);
                    if(!visit[start]) P++;
                    start++;
                    cnt--;
                }
                else {
                    P--;
                    cnt++;
                    end++;
                }
            }
        }
    }
}