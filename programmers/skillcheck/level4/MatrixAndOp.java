package skillcheck.level3;

import java.util.ArrayDeque;
import java.util.LinkedList;

/*
* 행렬과 연산
*
* 와... 진짜 너무 너무 재밌는 문제였다. (손도 못댔지만..)
*
* 연결리스트 혹은 덱으로 주어진 행렬을 분해해서
* O(1)로 연산하는 과정을 거쳐서 풀어야 했던 문제다..!
*
* 규칙을 찾는 것도 중요하고,
* 해당 규칙을 적!절!한! **자료구조**를 선택해서 구현하는 것도 중요하다..!
*
* (자료구조를 잘못 적용하면 인덱스 노가다, 삽질 등을 하게 된다!! -> 대회 나가시는 분들은 그렇게도 푸시는 듯 하다..!)
*
* */

public class MatrixAndOp {

    int r, c;
    ArrayDeque<Integer> col1, col2;
    LinkedList<ArrayDeque<Integer>> rows;

    private void init(int[][] rc) {
        r = rc.length;
        c = rc[0].length;

        col1 = new ArrayDeque<>();
        col2 = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            col1.add(rc[i][0]);
            col2.add(rc[i][c-1]);
        }

        rows = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < c-1; j++) {
                tmp.add(rc[i][j]);
            }
            rows.add(tmp);
        }
    }

    private int[][] getAnswer() {
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            ans[i][0] = col1.pollFirst();
            ans[i][c-1] = col2.pollFirst();
        }
        int i = 0;
        for (ArrayDeque<Integer> row : rows) {
            for (int j = 1; j < c-1; j++) {
                ans[i][j] = row.pollFirst();
            }
            i++;
        }
        return ans;
    }

    private void rotate() {
        if (c == 2) {
            col2.addFirst(col1.pollFirst());
            col1.addLast(col2.pollLast());
            return;
        }
        rows.peekFirst().addFirst(col1.pollFirst());
        col2.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(col2.pollLast());
        col1.addLast(rows.peekLast().pollFirst());
    }

    private void shiftRow() {
        rows.addFirst(rows.pollLast());
        col1.addFirst(col1.pollLast());
        col2.addFirst(col2.pollLast());
    }

    public int[][] solution(int[][] rc, String[] operations) {
        init(rc);
        for (String op : operations) {
            switch (op.charAt(0)) {
                case 'R' : rotate();    break;
                case 'S' : shiftRow();  break;
            }
        }
        return getAnswer();
    }
}
