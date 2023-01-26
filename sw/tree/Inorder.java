package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Inorder {
    static char[] tree;
    static int N;
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            tree = new char[N+1];

            for(int i = 1; i <= N; i++) {
                StringTokenizer st =  new StringTokenizer(br.readLine());

                st.nextToken();

                tree[i] = st.nextToken().charAt(0);
            }

            sb.append("#" + test_case + " ");
            inOrder(1);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void inOrder(int idx) { // 중위 순회
        if(idx > N) return;
        inOrder(2 * idx);
        sb.append(tree[idx]);
        inOrder(2 * idx + 1);
    }

}