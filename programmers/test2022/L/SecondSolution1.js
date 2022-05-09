// 정렬된 LinkedList에 데이터 삽입

// 문제를 계속 의심했다. 창피하다.
// 참조를 잘 모른다면 엄청나게 어려운 것 같다. !!  Reference !! Reference !!
// 자주 풀면 도움이 될 것 같다.

// 풀 때 종이와 펜이 필요한 것 같다.

class Node {
    constructor(number, param2) {
        this.value = number
        this.next = param2
    }

    value = null
    next = null

    Node(value, next) {
        this.value = value
        this.next = next
    }
}

class OrderedList {
    sentinel = null
    head = null

    OrderedList() {
        this.sentinel = this.head = new Node(100001, null)
    }

    insert(value) {
        this.head = this.rinsert(this.head, value);
    }

    rinsert(node, value) {
        if (node.value >= value) {
            node = new Node(value, node) // 빈칸 1: node
        } else {
            node.next = this.rinsert(node.next, value) // 빈칸 2: node.next, 빈칸 3: node:next
        }
        return node
    }

    print() {
        let node;
        node = this.head
        while(node != this.sentinel) {
            console.log(node.value + ' ')
            node = node.next
        }
        console.log('\n');
    }
}

function main() {
    list = new OrderedList();
    list.OrderedList();
    list.insert(10)
    list.print() // 결과: 10
    list.insert(5)
    list.print() // 결과: 5, 10
    list.insert(15)
    list.print() // 결과: 5, 10, 15
    list.insert(8)
    list.print() // 결과: 5, 8, 10, 15
    list.insert(10)
    list.print() // 결과: 5, 8, 10, 10, 15
}

main();