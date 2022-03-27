package programmers.test2022.L;

import java.util.*;
import java.util.regex.Pattern;

// 1번
// 1개의 정규식만 적용해서 문제를 풀 수 있었다.
// 3시간에 5솔했는데 1번 푸는데 1시간이 넘게 걸려서 억울해서 정규식 공부했다.
// https://jaehoney.tistory.com/143

class Solution {

    String[] parser = new String[]{"team_name : ", "application_name : ", "error_level : ", "message : "};

    public int solution(String[] logs) {
        long answer = Arrays.stream(logs).filter(log -> {
            try {
                if(log.length() > 100) return true;
                StringBuilder sb = new StringBuilder(log);
                for(int i=0; i<4; i++) {
                    if(!parser[i].equals(sb.substring(0, parser[i].length()))) {
                        return true;
                    }

                    sb.delete(0, parser[i].length());
                    if(i != 3) {
                        if(!Pattern.matches("^[a-zA-Z]*$", sb.substring(0, sb.indexOf(" ")))) {
                            return true;
                        };
                    } else {
                        if(!Pattern.matches("^[a-zA-Z]*$", sb.substring(0, sb.length()))) {
                            return true;
                        };
                    }
                    sb.delete(0, (i == 3 && sb.indexOf(" ") == -1) ? sb.length() : sb.indexOf(" ") + 1);
                }
                return sb.length() != 0;
            } catch (Exception e) {
                return true;
            }

        }).count();
        return (int)answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"};
        System.out.println(solution.solution(str));

    }
}