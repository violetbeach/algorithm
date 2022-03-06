package me.whiteship.interview._05_tree_02;

public class BuildTree {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        Node root = buildTree.build(new int[]{4, 2, 5, 1, 6, 3}, new int[]{1, 2, 4, 5, 3, 6});
        printInOrder(root);
    }

    private static void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.value);
            printInOrder(root.right);
        }
    }

    /**
     * TODO 문제. 중위탐색과 전위탐색 결과를 가지고 이진 트리를 만드는 코드를 작성하라.
     *  중위탐색(LDR): 4, 2, 5, 1, 3
     *  전위탐색(DLR): 1, 2, 4, 5, 3
     */
    private Node build(int[] inOrder, int[] preOrder) {
        return buildRecurse(inOrder, preOrder, 0, inOrder.length - 1);
    }

    int preIndex = 0;
    private Node buildRecurse(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }

        Node node = new Node(preOrder[preIndex++]);

        if(startIndex == endIndex) {
            return node;
        }

        int inIndex = searchIndex(inOrder, node.value);
        node.left = buildRecurse(inOrder, preOrder, startIndex, inIndex - 1);
        node.right = buildRecurse(inOrder, preOrder, inIndex + 1, endIndex);

        return node;
    }

    private int searchIndex(int[] inOrder, int value) {
        for (int i = 0; i < inOrder.length; i++) {
            if(inOrder[i] == value) {
                return i;
            }

        }
        return 0;
    }

}
