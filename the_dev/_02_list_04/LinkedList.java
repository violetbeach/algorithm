package the_dev._02_list_04;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        LinkedNode node3 = new LinkedNode(3);
        list.add(node3);
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));
        list.add(node3);

//        list.print();
        System.out.println(list.hasCircle());
    }

    /**
     * TODO 주어진 연결 리스트가 원형 연결 리스트인지 단일 연결 리스트인지 확인하는 함수를 구현하라.
     *  예) 1 -> 2 -> 3 -> 1   => true
     *  예) 1 -> 2 -> 3 -> 2   => true
     *  예) 1 -> 2 -> 3        => false
     * @return
     */

    // 대..박.. 신기하다.. 시간복잡도 O(n)인데, 공간복잡도도 O(1).. 훌륭한 알고리즘을 적용한 것 같다.
    private boolean hasCircle() {
        LinkedNode slow = this.head;
        LinkedNode fast = this.head;

        while(fast != null) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
        }

        return false;
    }
    private void print() {
        LinkedNode nodeToPrint = this.head;
        while(nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

}
