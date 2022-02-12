package programmers.test2021.kakao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 양과 늑대

// 트리 문제라고 해서 꼭 트리를 구현해야하는 것은 아니었다.
// 자신의 번호와, 부모의 번호를 보관해서라도 억지로 트리로 구현했는데, 대부분 트리를 안쓰셨다..ㅎㅎ

// 참고한 풀이에서는 같은 Node를 또 탐색하면 안되서 탐색한 node를 제거 후 복사를 계속 했었는데, 저기는 내가 쓴 flag 배열이 더 좋은 것 같다.
// 하나도 어려운 문제는 아니었다. 트리, 그래프 문제를 보면 풀이 경험이 적어서 겁을 조금 먹는 것 같다.

public class Test5 {

    private static int MaxCnt;
    private static Map<Integer, List<Integer>> nodes;
    public int solution(int[] info, int[][] edges) {
        MaxCnt = 0;
        nodes = new HashMap<>();
        for(int[] e : edges) {
            if(!nodes.containsKey(e[0])) nodes.put(e[0], new ArrayList<>());
            nodes.get(e[0]).add(e[1]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list, info);
        return MaxCnt;
    }
    public void dfs(int idx, int s, int w, List<Integer> list, int[] info) {
        if(info[idx]==0) s+=1;
        else w+=1;
        if(s<=w) return;

        MaxCnt = Math.max(MaxCnt, s);

        List<Integer> next = new ArrayList<>();
        next.addAll(list);
        if(nodes.containsKey(idx)) next.addAll(nodes.get(idx));
        next.remove(Integer.valueOf(idx));

        for(int n : next) {
            dfs(n, s, w, next, info);
        }

        return;
    }

    public static void main(String[] args) {
        Test5 a = new Test5();
    }
}
