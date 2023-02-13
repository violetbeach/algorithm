package hash;

import java.util.Scanner;

class EungisBicPicture {
    static final int DIV = (1<<30) - 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int H,W,N,M;

        int[][] myPic = new int[2000][2000];
        int[][] tchPic = new int[2000][2000];
        int[][] tchSam = new int[2000][2000];

        int[][] tmp = new int[2000][2000];

        for(int tc = 1; tc <= T; tc++) {
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            for(int h = 0; h < H; h++) {
                String line = sc.next();
                for (int w = 0; w < W; w++) {
                    char a = line.charAt(w);
                    if (a == 'o') myPic[h][w] = 1;
                    else myPic[h][w] = 0;
                }
            }

            for(int n = 0; n < N; n++) {
                String line = sc.next();
                for(int m = 0; m < M; m++) {
                    char a = line.charAt(m);
                    if(a == 'o') tchPic[n][m] = 1;
                    else tchPic[n][m] = 0;
                }
            }

            // Get My Hash
            for(int i = 0; i < H; i++) tmp[0][i] = getHash(myPic[i], W, 4);
            int myHash = getHash(tmp[0], H, 5);

            // Get Sam Hash
            int mulC = calcMul(W, 4);
            int mulR = calcMul(H, 5);
            for(int i = 0; i < N; i++) {
                tmp[0][i] = getHash(tchPic[i], W, 4);
                for(int j = 1; j < M - W + 1; j++) {
                    tmp[j][i] = getNext(tmp[j-1][i], tchPic[i][j-1], mulC, tchPic[i][j+W-1], 4);
                }
            }
            for(int i = 0; i < M - W + 1; i++) {
                tchSam[0][i] = getHash(tmp[i], H, 5);
                for(int j = 1; j < N - H + 1; j++) {
                    tchSam[j][i] = getNext(tchSam[j-1][i], tmp[i][j-1], mulR, tmp[i][j+H-1], 5);
                }
            }

            // Compare
            int cnt = 0;
            for(int i = 0; i < N - H + 1; i++) {
                for(int j = 0; j < M - W + 1; j++)
                    if(tchSam[i][j] == myHash) cnt++;
            }

            System.out.printf("#%d %d\n", tc, cnt);
        }
    }

    static int calcMul(int num, int shift) {
        long rev = 1;
        for(int i = 1; i < num; i++) {
            rev = (rev << shift) + rev;
        }
        return (int) (rev & DIV);
    }

    static int getHash(int[] piv, int num, int shift) {
        long hash = 0;
        for(int i = 0; i < num; i++) {
            hash = (hash << shift) + hash + piv[i];
        }
        return (int) (hash & DIV);
    }

    static int getNext(int prev, int sub, int mul, int add, int shift) {
        long hash = prev - ((long) sub * mul);
        hash = (hash << shift) + hash + add;
        return (int) (hash & DIV);
    }
}