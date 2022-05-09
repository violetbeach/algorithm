// 이진 탐색 호출 수 구하기
// 무진장 어려움. 괴물들이나 가능할 것 같지만, 나도 괴물이 되자!

var count = 0;

class SwitchCollection {
    value = null
    left = new Set()
    right = new Set()
    direction = -1

    add(value) {
        if (this.value == null) {
            this.value = value
        } else {
            if (this.direction == -1) {
                this.left.add(value)
            } else {
                this.right.add(value)
            }
            this.direction *= -1
        }
    }

    contains(value) {
        count++;
        if (this.value == value) {
            return true
        } else {
            var result;
            if (this.direction == -1) {
                result = this.left.has(value)
            } else {
                result = this.right.has(value)
            }
            this.direction *= -1
            return result;
        }
    }
}

var c = new SwitchCollection()

var test = 11
for (var i=1; i<=test; i++) {
    c.add(i)
}

i = 1
for (var i=1; i<=test; i++) {
    if (c.contains(i)) {
        i++;
    }
}

console.log(count); // 답: 8 -> 11 22 44 66 88