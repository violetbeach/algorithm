import java.util.*;

public class Solution2 {

    String[] inputMap;
    boolean[][] checked;
    int rowLen;
    int colLen;

    public int solution(String[] maps) {
        inputMap = maps;
        rowLen = maps.length;
        colLen = maps[0].length();

        checked = new boolean[rowLen][colLen];
        List<Map<String, Integer>> list = new ArrayList<>();

        int x = 0, y = 0;
        while(y != rowLen) {
            if(inputMap[y].charAt(x) != '.' && !checked[y][x]) {
                Map<String, Integer> hmap = new HashMap<>();
                list.add(hmap);
                dfs(hmap, x, y);
            }
            if(x == colLen - 1) {
                x = 0;
                y++;
                continue;
            }
            x++;
        }

        for(Map<String, Integer> one : list) {
            String winCountry = "a";
            int winCount = 0;
            boolean first = true;
            List<Map.Entry<String, Integer>> entries = new LinkedList<>(one.entrySet());
            entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            for (Map.Entry<String, Integer> entry : entries) {
                if(winCount < entry.getValue() || (winCount == entry.getValue() && entry.getKey().charAt(0) > winCountry.charAt(0))) {
                    winCountry = entry.getKey();
                }
                if(first) {
                    winCount = entry.getValue();
                    first = false;
                }

                if(winCount > entry.getValue()) {
                    one.put(winCountry, one.get(winCountry) + entry.getValue());
                    entry.setValue(0);
                }
            }
        }

        Map<String, Integer> answer = new HashMap<>();
        for(Map<String, Integer> one : list) {

            for (Map.Entry<String, Integer> entry : one.entrySet()) {
                answer.put(entry.getKey(), answer.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }

        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(answer.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return entries.iterator().next().getValue();
    }

    public void dfs(Map<String, Integer> map, int x, int y) {
        if(checked[y][x]) {
            return;
        }

        checked[y][x] = true;

        String cur = inputMap[y].substring(x, x+1);
        if(!cur.equals(".")) {
            int tmp = map.getOrDefault(cur, 0);
            map.put(cur, tmp + 1);
        } else {
            return;
        }

        if(x-1 >= 0) {
            dfs(map, x-1, y);
        }

        if(x+1 < colLen) {
            dfs(map, x+1, y);
        }

        if(y+1 < rowLen) {
            dfs(map, x, y+1);
        }

        if(y-1 >= 0) {
            dfs(map, x, y-1);
        }

    }

    public static void main(String[] args) {
        String[] str = {"AAAA....BBCD", "AAAA....EEFF", "AAAAZZMMFFCC"};
        Solution2 solution = new Solution2();
        int solution1 = solution.solution(str);
        System.out.println(solution1);

    }
}
