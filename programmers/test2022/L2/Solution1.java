import java.util.*;

public class Solution1 {

    public String[] solution(String[] logs) {
        Map<String, Set<String>> solves = new HashMap<>();
        Set<String> people = new HashSet<>();

        for (String log : logs) {
            String[] temp = log.split(" ");
            Set<String> users = solves.getOrDefault(temp[1], new HashSet<>());
            users.add(temp[0]);
            solves.put(temp[1], users);
            people.add(temp[0]);
        }

        List<String> result = new ArrayList<>();
        for (String question : solves.keySet()) {
            if(solves.get(question).size() >= (double)people.size() / 2) {
                result.add(question);
            }
        }

        Collections.sort(result);

        return result.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] s = {"morgan string_compare", "felix string_compare", "morgan reverse", "rohan sort", "andy reverse", "morgan sqrt"};
        System.out.println(Arrays.toString(new Solution1().solution(s)));
    }
}
