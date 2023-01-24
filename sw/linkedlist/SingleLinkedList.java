class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        node = new Node[MAX_NODE];
    }

    public void addNode2Head(int data) {
        Node nextNode = head.next;
    }

    public void addNode2Tail(int data) {

    }

    public void addNode2Num(int data, int num) {

    }

    public void removeNode(int data) {

    }

    public int getList(int[] output) {
        return 1;
    }
}