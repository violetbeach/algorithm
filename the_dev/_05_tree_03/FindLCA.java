package me.whiteship.interview._05_tree_03;

import java.util.ArrayList;
import java.util.List;

public class FindLCA {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        FindLCA findLCA = new FindLCA();
        System.out.println(findLCA.solution(root, 4, 5)); // 2
        System.out.println(findLCA.solution(root, 2, 5)); // 2
        System.out.println(findLCA.solution(root, 3, 4)); // 1
        System.out.println(findLCA.solution(root, 3, 7)); // 3

    }

    /**
     * TODO 주어진 이진 트리 (node) 에서 두 노드 n1, n2의 가장 가까운 공통 조상(Lowest Common Ancestor)을 찾는 코드를 작성하라.
     */
    private Node solution(Node root, int n1, int n2) {
        List<Node> n1path = new ArrayList<>();
        List<Node> n2path = new ArrayList<>();
        if(!findPath(root, n1, n1path) || !findPath(root, n2, n2path)) {
            return null;
        }

        int index = 0;
        for(; index < n1path.size() && index < n2path.size(); index++) {
            if(!n1path.get(index).equals(n2path.get(index))) {
                break;
            }
        }

        return n1path.get(index - 1);
    }

    private boolean findPath(Node node, int number, List<Node> path) {
        if(node == null) {
            return false;
        }

        path.add(node);

        if(node.value == number) {
            return true;
        }

        if(findPath(node.left, number, path)) {
            return true;
        }

        if(findPath(node.right, number, path)) {
            return true;
        }

        path.remove(node);
        return false;

    }

}
