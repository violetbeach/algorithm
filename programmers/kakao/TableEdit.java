package kakao;

import java.util.Arrays;
import java.util.Stack;

/*
* 표 편집
*
* 푸는 내내 이게 왜 Level3인지 의구심이 들었다.
*
* 알고보니 이중 연결리스트를 반드시 구현해야했던 문제다.
* soft-delete를 했을 떄 중간 원소들을 건너뛰는 과정에서 리소스를 많이 잡아먹기 때문이다.
*
* 잘 못풀었지만 중요한 유형을 익혔다.
* */

class TableEdit {
    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c == 'U') {
                int num = Integer.valueOf(cmd[i].substring(2));
                while(num-- > 0) {
                    k = pre[k];
                }
            } else if(c == 'D') {
                int num = Integer.valueOf(cmd[i].substring(2));
                while(num-- > 0) {
                    k = next[k];
                }
            } else if(c == 'C') {
                stack.push(new Node(pre[k], k, next[k]));
                if(pre[k] != -1) next[pre[k]] = next[k]; //현재 노드 삭제 후 앞뒤 연결
                if(next[k] != -1) pre[next[k]] = pre[k];
                sb.setCharAt(k, 'X');

                if(next[k] != -1) k = next[k];
                else k = pre[k]; //마지막 행인 경우에 바로 윗 행 선택
            } else {
                Node node = stack.pop();
                if(node.pre != -1) next[node.pre] = node.cur; //연결 정보 복구
                if(node.nxt != -1) pre[node.nxt] = node.cur;
                sb.setCharAt(node.cur, 'O');
            }
        }
        return sb.toString();
    }

    public class Node{
        int pre, cur, nxt;

        public Node(int pre, int cur, int nxt) {
            this.pre = pre;
            this.cur = cur;
            this.nxt = nxt;
        }
    }
}
