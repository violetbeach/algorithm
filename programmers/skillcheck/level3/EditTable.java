package skillcheck.level3;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/*
* 표 편집
*
* LinkedList 라이브러리로 구현가능할 지 알았지만, 그럴 수 없었다.
* (복구를 할 때 처리가 너무 복잡해지기 때문)
* 문제를 풀기 전에 기술이 적용이 가능한 지 철저히 따져보는 것이 중요하다.
*
*  -> 연결 리스트 라이브러리의 활용이 아닌 prev[], next[] 배열과 Node class를 활용해서 복구가 가능하도록 처리했어야 했다.
* 그리고 코드를 갈아 엎는 것을 너무 어렵게 여긴다. 빨리 빨리 갈아 엎으면 충분히 빠른 시간 내로 풀이가 가능했다.
*
* */

public class EditTable {

    public String solution(int n, int k, String[] cmds) {

        boolean[] isDeleted = new boolean[n];

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }

        ListIterator<Integer> iter = list.listIterator(k);
        Stack<Integer> stack = new Stack<>();

        int pointer = 0;
        for(String cmd : cmds) {
            char command = cmd.charAt(0);

            switch (command) {
                case 'U':
                    for(int i = 0; i < Character.getNumericValue(cmd.charAt(2)); i++) {
                        pointer = iter.previous();
                    }
                    break;
                case 'D':
                    for(int i = 0; i < Character.getNumericValue(cmd.charAt(2)); i++) {
                        pointer = iter.next();
                    }
                    break;
                case 'C':
                    stack.push(pointer);
                    iter.remove();
                     if(iter.hasNext()) {
                         pointer = iter.next();
                     } else {
                         pointer = iter.previous();
                     }
                    break;
                default:
                    Integer restore = stack.pop();
                    if(restore > pointer) {
                        while(restore > pointer) {
                            if(iter.hasNext()) {
                                pointer = iter.next();
                            }
                        }
                        iter.previous();
                        iter.add(restore);
                    }

                    break;

            }
        }

        return null;

    }

}
