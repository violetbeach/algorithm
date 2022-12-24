package skillcheck.level3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
* 모두 0으로 만들기
*
* 정점과 간선이 주어졌고, 이가 트리라고는 했지만 간선의 0번이 부모인지 1번이 부모인지 알 수 없었다.
*
* 그래서, 루트 부모가 여러 개가 되는 사태가 발생했다 ㅠ
* (생각이 짧았다.) 여기서 실제 Node를 그리는 것이 아니라 visited를 활용하고, 양방향 배열로서 트리를 사용할 수 있었다.
*
* 즉, 정말로 필요한 것은 트리가 아니라 어떻게 해야 그래프의 끝까지 가서(여기서 dfs 힌트가 나왔다.) 모든 그래프를 순회할 수 있는 지 였다.
* */

public class MakeZeroAll {

    long answer = 0;

    public long solution(int[] a, int[][] edges) {
        List<Node> list = new ArrayList<>();

        for (int value : a) {
            list.add(new Node(value));
        }

        for (int[] edge : edges) {
            Node node = list.get(edge[0]);

            Node son = list.get(edge[1]);
            node.addSon(son);

            son.addParent(node);
        }

        Node head = getHead(list);
        head.execute();

        return answer;
    }

    private Node getHead(List<Node> list) {
        for (Node node : list) {
            if (node.parents.isEmpty()) {
                return node;
            }
        }
        return null;
    }

    class Node {
        private int value;
        List<Node> parents;
        List<Node> sons;

        public Node(int value) {
            this.value = value;
            this.parents = new ArrayList<>();
            this.sons = new ArrayList<>();
        }

        public void addParent(Node parent) {
            parents.add(parent);
        }

        public void addSon(Node son) {
            sons.add(son);
        }

        public void execute() {
            for (Node son : sons) {
                son.execute();
            }
            if(value !=0 && !parents.isEmpty()) {
                parents.get(0).value += this.value;
                answer += Math.abs(this.value);
            }
        }

    }

    @Test
    void test() {
        int[] a = {-5, 0, 2, 1, 2};
        int[][] edges = {{0,1}, {3,4}, {2,3}, {0,3}};

        solution(a, edges);
    }

}
