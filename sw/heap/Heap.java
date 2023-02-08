package heap;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap {
    static void init() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int dolist = sc.nextInt();
            System.out.print("#" + t + " ");
            solve(dolist, sc);
            System.out.println();
        }
    }

    static void solve(int dolist, Scanner sc) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int d = 0; d < dolist; d++) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    int value = sc.nextInt();
                    q.add(value);
                    break;
                case 2:
                    int output;
                    if (q.isEmpty())
                        output = -1;
                    else
                        output = q.poll();
                    System.out.print(output + " ");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        init();
    }
}