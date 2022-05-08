package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

// 카카오 - 불량 사용자
// dfs를 할 떄 호출 후 remove하면 자료구조를 재활용할 수 있다.

// 비트마스크를 활용하신 분도 있었는데 Set<Set> 구조를 피하고 Set<Integer>로 해서 Integer에 비트로 조합을 넣었다.


public class BadUser {

    HashSet<HashSet<String>> result;
    ArrayList<ArrayList<String>> bannedUserList;

    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<HashSet<String>>();
        bannedUserList = new ArrayList<ArrayList<String>>();

        for (String bannedId : banned_id) {
            // 목록의 n번째 칸에 들갈 수 있는 제재 아이디들 구함
            bannedUserList.add(getMatchesId(bannedId, user_id));
        }

        dfs(new HashSet<String>(), 0);

        return result.size();
    }

    ArrayList<String> getMatchesId(String bannedId, String[] user_id) {
        // 불량 사용자 아이디 정규 표현식으로 변환
        // 정규 표현식에서 '.' = 임의의 문자열 1개
        String pattern = bannedId.replace('*', '.');

        java.util.ArrayList<String> valueList = new ArrayList<>();

        for (String userId : user_id) {
            boolean isMatch = Pattern.matches(pattern, userId);

            // 정규 표현식 턴에 맞는 유저 아이디 담음
            if (isMatch)
                valueList.add(userId);
        }

        return valueList;
    }

    void dfs(HashSet<String> add, int depth) {
        if (depth == bannedUserList.size()) {
            // 결과 Set에 저장
            result.add(new HashSet<>(add));
            return;
        }

        // depth번째에 들어갈 수 있는 아이디 목록에서 뽑음
        for (String userId : bannedUserList.get(depth)) {
            // 이미 목록에 들어가있으면 담지 않음
            if (!add.contains(userId)) {
                add.add(userId);
                dfs(add, depth + 1);
                add.remove(userId);
            }
        }

    }

    /*
     * 비트마스크 풀이
     * */

    Set<Integer> set;

    public int solution2(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        go(0, user_id, banned_id, 0);

        return set.size();
    }

    public void go(int index, String[] user_id, String[] banned_id, int bit) {

        if(index == banned_id.length) {
            set.add(bit);
            return;
        }

        String reg = banned_id[index].replace("*", "[\\w\\d]");
        for(int i=0; i<user_id.length; ++i) {
            if((((bit>>i) & 1) == 1) || !user_id[i].matches(reg)) continue;
            go(index + 1, user_id, banned_id, (bit | 1<<i));
        }

    }

    public static void main(String[] args) {
        BadUser badUser = new BadUser();
        String[] a = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] b = {"*rodo", "*rodo", "******"};
        System.out.println(badUser.solution(a, b));
    }
}
