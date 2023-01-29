package graph;

/////////////////////////////////////////////////////////////////////////////////////////////
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
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class ConnectProcess
{
    static class Process {
        int y;
        int x;

        Process(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static int[][] map;
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };

    static ArrayList<Process> list;
    static int min;
    static int max;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ts = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= ts; t++) {

            N = Integer.parseInt(br.readLine().trim());

            map = new int[N][N];
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i - 1 < 0 || j - 1 < 0 || i + 1 >= N || j + 1 >= N)
                            continue;
                        list.add(new Process(i, j)); // 벽이 아닌 코어 저장
                    }
                }
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            dfs(0,0,0);

            System.out.println("#" + t + " " + min);
        }

    }

    public static void dfs(int idx, int coreCnt, int len) {

        //종료조건 : 증가되는 인덱스가 list의 사이즈만큼 되었을 때
        if(idx == list.size()) {
            if(max < coreCnt) { // 코어 개수가 더 많아서 갱신해야할 때
                max = coreCnt;
                min = len;
            }
            else if (max == coreCnt) { // 코어 개수가 같아서 길이 비교
                if(min > len) min = len;
            }
            return;
        }

        int y = list.get(idx).y;
        int x = list.get(idx).x;

        for (int dir = 0; dir < 4; dir++) {

            int count = 0;
            int originY = y;
            int originX = x;
            int ny = y;
            int nx = x;

            while(true) {
                ny += dy[dir];
                nx += dx[dir];

                if(ny < 0 || nx < 0 || ny>=N || nx>=N) { // 벽을 만날때까지
                    break;
                }

                if(map[ny][nx] == 1) { // 전선을 만나면 못가는 곳
                    count = 0;
                    break;
                }

                count++;
            }

            //len += count;

            for (int i = 0; i < count; i++) {
                originY += dy[dir];
                originX += dx[dir];

                map[originY][originX] = 1;
            }

            if(count == 0) { // 전선을 연결할 수 없는 코어
                dfs(idx+1, coreCnt, len);
            }
            else {
                dfs(idx+1, coreCnt+1, len+count);

                originY = y;
                originX = x;
                for (int i = 0; i < count; i++) {
                    originY += dy[dir];
                    originX += dx[dir];

                    map[originY][originX] = 0;
                }
                //len -= count;
            }

        }

    }
}