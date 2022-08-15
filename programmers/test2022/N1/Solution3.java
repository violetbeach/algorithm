package programmers.test2022.N1;

public class Solution3 {

    public int solution(int N) {
        boolean isPositive = N >= 0;
        String sNum = isPositive ? Integer.toString(N) : Integer.toString(-N);

        int goodIndex = getGoodIndex(isPositive, sNum);

        StringBuilder sb = new StringBuilder(sNum);
        sb.insert(goodIndex, 5);

        if(!isPositive) {
            sb.insert(0, "-");
        }

        return Integer.parseInt(sb.toString());
    }

    public int getGoodIndex(boolean isPositive, String sNum) {
        for(int i = 0; i < sNum.length(); i++) {

            int intNum = Character.getNumericValue(sNum.charAt(i));
            if(isPositive) {
                if(intNum <= 5) {
                    return i;
                }
            }

            if(!isPositive) {
                if(intNum > 5) {
                    return i;
                }

                if(intNum == 5) {
                    for(int j = i; j < sNum.length(); j++) {
                        if(Character.getNumericValue(sNum.charAt(j)) > 5) {
                            return j;
                        }
                    }
                }
            }

        }

        return sNum.length();

    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(268));
    }

}
