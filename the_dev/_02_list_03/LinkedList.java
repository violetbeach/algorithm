package the_dev._02_list_03;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(4));

        list.print();
        list.removeDuplicates();
        list.print();
    }

    /**
     * TODO 정렬된 연결 리스트에서 중복가 노드를 제거하는 함수를 구현하라.
     *  예) 1 -> 1 -> 1 -> 2 -> 3 -> 3   =>   1 -> 2 -> 3
     * @return
     */

    // 정렬 된 것 인지 몰랐음. 정렬 된거 였으면, 포인터 두개 사용해서 같이 가면서 검증하면됨. 내 풀이도 괜찮음.
    private void removeDuplicates() {
        Set<Integer> hs = new HashSet<>();
        LinkedNode current = head;
        hs.add(current.number);

        while(current.next != null) {
            if(hs.contains(current.next.number)) {
                current.next = current.next.next;
            } else {
                hs.add(current.next.number);
                current = current.next;
            }
        }

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
