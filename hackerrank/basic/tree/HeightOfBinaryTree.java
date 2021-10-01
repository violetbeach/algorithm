package basic.tree;

public class HeightOfBinaryTree {
	
    class Node {
    	int data;
    	Node left;
    	Node right;
    }
	
	public static int height(Node root) {
        if(root == null) return -1;
        else return Math.max(height(root.left), height(root.right))+1;
    }

}
