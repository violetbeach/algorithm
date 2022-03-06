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
    // 주어진 이진트리에 두 값이 항상 있다고 가정하면, 트리를 한 번만 순회할 수 있음
    private Node solution(Node node, int n1, int n2) {
        if(node == null) {
            return null;
        }

        if(node.value == n1 || node.value == n2) {
            return node;
        }

        Node leftLCA = solution(node.left, n1, n2);
        Node rightLCA = solution(node.right, n1, n2);

        if(leftLCA != null && rightLCA != null) {
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;

    }

}
