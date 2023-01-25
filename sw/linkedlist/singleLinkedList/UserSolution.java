package linkedlist.singleLinkedList;

class UserSolution {

    class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        nodeCnt = 0;
        head = getNode(-1);
    }

    public void addNode2Head(int data) {
        Node nNode = getNode(data);
        nNode.next = head.next;
        head.next = nNode;
    }

    public void addNode2Tail(int data) {
        Node nNode = getNode(data);
        Node tmp = head;

        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = nNode;

    }

    public void addNode2Num(int data, int num) {
        Node nNode = getNode(data);
        Node tmp = head;

        for (int i = 0; i < num-1; i++){
            tmp = tmp.next;
        }
        nNode.next = tmp.next;
        tmp.next = nNode;
    }

    public void removeNode(int data) {
        Node tmp = head;
        Node rmvNode = null;

        while (tmp.next != null){
            if (tmp.next.data == data){
                rmvNode = tmp.next;
                break;
            }
            tmp = tmp.next;
        }

        if (rmvNode != null){
            tmp.next = rmvNode.next;
            nodeCnt--;
        }
    }

    public int getList(int[] output) {
        Node tmp = head;
        int cnt = 0;

        while (tmp.next != null){
            output[cnt++] = tmp.next.data;
            tmp = tmp.next;
        }

        return cnt;
    }
}