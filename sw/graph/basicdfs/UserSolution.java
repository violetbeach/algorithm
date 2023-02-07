package graph.basicdfs;

public class UserSolution {

    int[] counts;
    Node[] nodes;
    int answer;
    public void dfs_init(int N, int[][] path) {
        nodes = new Node[100];
        counts = new int[100];

        for(int i = 1; i < 100; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < path.length; i++) {
            if(path[i][0] == path[i][1]) {
                break;
            }
            nodes[path[i][0]].children[counts[path[i][0]]] = nodes[path[i][1]];
            counts[path[i][0]]++;
        }
    }

    public int dfs(int N) {
        answer = -1;
        myDfs(N, N);
        return answer;
    }

    public void myDfs(int N, int init) {
        Node node = nodes[N];

        if(node.value > init) {
            answer = node.value;
            return;
        }

        for(int i = 0; i  < counts[N]; i++) {
            myDfs(node.children[i].value, init);
            if(answer != -1) {
                return;
            }
        }

    }

    static class Node {
        int value;
        Node[] children;

        public Node(int value) {
            this.value = value;
            this.children = new Node[5];
        }
    }
}