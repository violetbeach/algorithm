public class Solution3 {

    public int solution(int N) {
        boolean isPositive = N >= 0;
        String sNum = isPositive ? Integer.toString(N) : Integer.toString(-N);

        int index = getIndex(isPositive, sNum);

        StringBuilder sb = new StringBuilder(sNum);
        sb.insert(index, 5);

        if(!isPositive) {
            sb.insert(0, "-");
        }

        return Integer.parseInt(sb.toString());
    }

    public int getIndex(boolean atLeastZero, String sNum) {
        for(int i = 0; i < sNum.length(); i++) {

            int intNum = Character.getNumericValue(sNum.charAt(i));
            if(atLeastZero) {
                if(intNum <= 5) {
                    return i;
                }
            }

            if(!atLeastZero) {
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

}
