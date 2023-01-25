package linkedlist.doubleLinkedList;

/*
* 각 Node를 양쪽에서 붙이는 메서드를 사용했으면 더 깔끔했을 것 같다.
* 추가로 null 검증을 한 후 null이라면 안붙이는 처리를 한다면 공통 관심사를 분리할 수 있을 것 같다.
*
* (반영 완료!) -> 완전 깔끔
* */

public class UserSolution {

    class Node {
        public int data;
        public Node prev;
        public Node next;

        public void setNext(Node next) {
            this.next = next;
            if(next != null) {
                next.prev = this;
            }
        }

        public Node(int data) {
            this.data = data;
            this.prev = null;
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
        Node node = getNode(data);

        node.setNext(head.next);
        head.setNext(node);
    }

    public void addNode2Tail(int data) {
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }
        Node newNode = getNode(data);
        node.setNext(newNode);
    }

    public void addNode2Num(int data, int num) {
        Node node = head;
        while(num-- > 1) {
            node = node.next;
        }
        Node newNode = getNode(data);
        newNode.setNext(node.next);

        node.setNext(newNode);
    }

    public int findNode(int data) {
        int i = 0;
        Node node = head;
        while(node.data != data) {
            node = node.next;
            i++;
        }
        return i;
    }

    public void removeNode(int data) {
        Node node = head;
        while(node != null && node.data != data) {
             node = node.next;
        }
        if(node == null) {
            return;
        }

        node.prev.setNext(node.next);

        nodeCnt--;
    }

    public int getList(int[] output) {
        int i = 0;
        Node node = head.next;
        while(node != null) {
            output[i] = node.data;
            node = node.next;
            i++;
        }
        return i;
    }

    public int getReversedList(int[] output) {
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }

        int i = 0;
        while(node != head) {
            output[i] = node.data;
            node = node.prev;
            i++;
        }
        return i;
    }
}