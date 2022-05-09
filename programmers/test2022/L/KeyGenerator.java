package programmers.test2022.L;

// 세 문제짜리였는데, 다틀렸다!
// 그래도 되게 재밌었다! 다음엔 CS도 잘풀고 재귀도 잘읽을 것 같다.

public class KeyGenerator {

    public String generateKey(String seedKey, int[] repeatCounts) {
        return recursivelyGenerate("", 0, seedKey, repeatCounts);
    }

    private String recursivelyGenerate(String latestKey, int currentIndex, String seedKey, int[] repeatCounts) {
        if(currentIndex == repeatCounts.length) {
            return latestKey;
        }
        int seedKeyIndex = currentIndex % seedKey.length();
        String nextKey = getNextKey(latestKey, seedKey.charAt(seedKeyIndex), repeatCounts[currentIndex]);
        return recursivelyGenerate(nextKey, currentIndex + 1, seedKey, repeatCounts);
    }

    private String getNextKey(String latestKey, char seed, int repeatCount) {
        String result = "";
        for(int i = 0; i< repeatCount; i++) {
            result += latestKey;
            result += seed;
        }
        result += latestKey;
        return result;
    }

    public static void main(String[] args) {
        String seed = "kts";
        int[] repeatCounts = new int[]{1, 3, 5};
        String output = new KeyGenerator().generateKey(seed, repeatCounts);
        System.out.println(output);
    }

}