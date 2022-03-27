package Line;

import java.util.*;

// 잘 풀었다.

public class Solution3 {

    public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        Set<String> officeTasks = new HashSet<String>(List.of(office_tasks));

        int[] countPerTeam = new int[num_teams];
        Map<Integer, List<Integer>> remoteUsers = new HashMap<>();
        int idx = 0;
        for(String employee : employees) {
            String[] split = employee.split(" ");
            countPerTeam[Integer.parseInt(split[0]) - 1]++;
            if(Arrays.stream(split).skip(1).noneMatch(officeTasks::contains)) {
                List<Integer> list = remoteUsers.getOrDefault(Integer.parseInt(split[0]) - 1, new ArrayList<>());
                list.add(idx + 1);
                remoteUsers.put(Integer.parseInt(split[0]) - 1, list);
            }
            idx++;
        }

        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<num_teams; i++) {
            List<Integer> remotes = remoteUsers.getOrDefault(i, new ArrayList<>());
            if(countPerTeam[i] != remotes.size()) {
                answer.addAll(remotes);
            } else {
                remotes.stream().skip(1).forEach(answer::add);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }

    record Employee(int teamNo, int No) {}

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[] a = {"development","marketing","hometask"};
        String[] b = {"recruitment","education","officetask"};
        String[] c = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};

        System.out.println(Arrays.toString(solution.solution(3, a, b, c)));
    }
}
