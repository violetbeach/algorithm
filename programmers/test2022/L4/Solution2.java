package programmers.test2022.L4;

import java.util.regex.Pattern;

public class Solution2 {

    public String solution(int k, String[] dic, String chat) {
        String[] split = chat.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : split) {
            String result = replaceBasic(chat, dic);
            sb.append(result);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        String answer = ruleString(chat, dic, k);
        return answer;
    }

    private String replaceBasic(String s, String[] dic) {
        for(String d : dic) {
            if(s.matches(d)) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<s.length(); i++) {
                    sb.append("#");
                }
                return sb.toString();
            }
        }

        return s;
    }

    private String ruleString(String chat, String[] dic, int k) {
        String[] split = chat.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : split) {
            sb.append(sliceRule(s, dic, k));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String sliceRule(String s, String[] dic, int k) {
        String regex = s.replace(".", String.format("[A-Za-z]{1,%s}", k));

        for(String d : dic) {
            if(d.matches(regex)) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i<s.length(); i++) {
                    sb.append("#");
                }
                return sb.toString();
            }
        }

        return s;
    }

}