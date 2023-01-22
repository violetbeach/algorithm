package linkedlist;
import java.util.*;
import java.io.*;

class Sequence {
    public static void main(String args[]) throws Exception {
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            List<Integer> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while (N-- > 0)
                list.add(Integer.parseInt(st.nextToken()));

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int idx, n;
                String cmd = st.nextToken();
                switch (cmd) {
                    case "I":
                        idx = Integer.parseInt(st.nextToken());
                        n = Integer.parseInt(st.nextToken());
                        list.add(idx, n);
                        break;
                    case "D":
                        idx = Integer.parseInt(st.nextToken());
                        list.remove(idx);
                        break;
                    case "C":
                        idx = Integer.parseInt(st.nextToken());
                        n = Integer.parseInt(st.nextToken());
                        list.set(idx, n);
                        break;
                    default:
                        break;
                }
            }

            int answer = list.size() > L ? list.get(L) : -1;
            System.out.println("#" + test_case + " " + answer);
        }
    }
}