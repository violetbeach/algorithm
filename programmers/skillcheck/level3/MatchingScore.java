package skillcheck.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 매칭 점수
*
* 복잡하다 ㅠ
*
* 부분 점수 75점은 받았지만, 완성 점수를 받지 못했다.
*
* 문제를 제대로 안읽어서 중간중간에 정책을 추가해주면서 실수가 터졌을 것 같다.
*
* Pattern 라이브러리에 대한 사용법을 익힐 수 있었다.
* 이제껏 정규식을 Filter나 카운팅 정도로만 화룡ㅇ했는데, Pattern을 사용하면 딱 정규식에 해당하는 문자열 추출이 가능하다. (List도 가능하다.)
*
* ** Matcher 클래스는 일회용 인스턴스를 위한 클래스이다. ** 1번만 사용하는 용도이며, **상태**를 가진다.
* find()함수를 쓸 때마다 group()으로 추출해야 한다.
*
* */

public class MatchingScore {

    int[] externalLinks;

    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        Pattern homeUrlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(.+)\"");
        Pattern linkUrlPattern = Pattern.compile("<a href=\"(.+)\"");

        externalLinks = new int[pages.length];

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> links = new HashMap<>();

        int[] basicScores = new int[pages.length];
        double[] answerArray = new double[pages.length];

        for (int i = 0; i < pages.length; i++) {
            String page = pages[i].toLowerCase().replaceAll("\\\\", "");

            executeHome(homeUrlPattern, map, i, page);

            countScore(word, page, basicScores, i);
            answerArray[i] += basicScores[i];

        }

        for(int i = 0; i < pages.length; i++) {
            String page = pages[i].toLowerCase().replaceAll("\\\\", "");

            executeLink(linkUrlPattern, map, links, i, page);
        }

        for(Map.Entry<Integer, List<Integer>> link : links.entrySet()) {
            int index = link.getKey();

            List<Integer> value = link.getValue();
            for (Integer linkPath : value) {
                answerArray[index] += (double) basicScores[linkPath] / externalLinks[linkPath];
            }


        }

        double max = 0;
        int maxIndex = 0;
        for(int i = 0; i < answerArray.length; i++) {
            if(max < answerArray[i]) {
                max = answerArray[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void executeLink(Pattern linkUrlPattern, Map<String, Integer> map, Map<Integer, List<Integer>> links, int i, String page) {
        Matcher linkMatcher = linkUrlPattern.matcher(page);

        while(linkMatcher.find()) {
            String linkTag = linkMatcher.group();
            String link = linkTag.split("=")[1].replace("\"", "");

            Integer target = map.get(link);
            if(target != null) {
                List<Integer> get = links.getOrDefault(target, new ArrayList<>());
                get.add(i);

                links.put(target, get);
            }
            externalLinks[i]++;
        }
    }

    private void executeHome(Pattern homeUrlPattern, Map<String, Integer> map, int i, String page) {
        Matcher homeMatcher = homeUrlPattern.matcher(page);
        // <meta property="og:url" content="(.+)"/>
        // <meta property="og:url" content="https://a.com"/>

        if(homeMatcher.find()) {
            String homeMetaTag = homeMatcher.group();
            String home = homeMetaTag.split("=")[2].replace("\"", "");
            map.put(home, i);
        }
    }

    private void countScore(String word, String page, int[] basicScores, int i) {
        String replace = page.replaceAll("[^a-zA-Z]", " ");

        String[] s = replace.split("\\s+");
        for (String s1 : s) {
            if(s1.equals(word)) {
                basicScores[i]++;
            }
        }
    }

    @Test
    void test() {
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        Assertions.assertEquals("0", solution("Muzi", pages));
    }

}
