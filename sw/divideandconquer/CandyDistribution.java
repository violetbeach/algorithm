package divideandconquer;/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
* 사탕 분배
*
* 작은 값 X는 항상 - 2X (mod S)가 됨
* (ok..)
*
* 그런데 해당 연산을 k번 반복하면 - X (2^K) (mod S) 이 나옴..! ㄷㄷ
*
* 참고: https://swexpertacademy.com/main/talk/codeBattle/boardCommuView.do?categoryId=AYWab_JKjkwDFAQK&searchCondition=COMMU_DETAIL-COMMU_TITLE&battleMainPageIndex=1&searchClsftn=&commuId=AYYMpacKiF4DFAVw&pageIndex=3
* */

class CandyDistribution
{
    static long c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            c = a + b;
            long res = (a * pow(2, K)) % c;

            long answer = Math.min(res, c - res);

            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }

    static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long res = pow(a, b / 2);
        if (b % 2 == 0) {
            return (res * res) % c;
        } else {
            return (res * res * a) % c;
        }
    }
}