package kakao;

import java.util.ArrayList;
import java.util.HashMap;

/*
* 후보키
*
* 카카오는 비트 마스크를 참 좋아한다.
* 2차원 SET을 사용해야 하는 순간 비트마스킹이라 보면 되는 것 같다 -_-;
* 익숙해지면 더 잘할 수 있을 것 같다.
* */

class CandidateKey {
    public int solution(String[][] relation) {
        ArrayList<Integer> candidateKey = new ArrayList<>();

        int rowLen = relation.length;
        int colLen = relation[0].length;

        for(int set = 1 ; set < (1 << colLen) ; set++) {
            // 최소성 검사
            if(!isMinimal(set, candidateKey)) continue;

            // 유일성 검사
            if(isUnique(set, rowLen, colLen, candidateKey, relation)) {
                candidateKey.add(set);
            }
        }

        return candidateKey.size();
    }

    private boolean isUnique(int set, int rowLen, int colLen, ArrayList<Integer> candidateKey, String[][] relation) {
        HashMap<String, String> map = new HashMap<>();

        for(int row = 0 ; row < rowLen ; ++row) {
            String dataByKeySet = "";

            for(int th = 0 ; th < colLen ; ++th) {
                if((set & (1 << th)) != 0) {
                    dataByKeySet += relation[row][th];
                }
            }

            if(map.containsKey(dataByKeySet)) return false;
            else map.put(dataByKeySet, dataByKeySet);
        }

        return true;
    }

    private boolean isMinimal(int set, ArrayList<Integer> candidateKey) {
        for(int key : candidateKey) {
            if((key & set) == key) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CandidateKey solution = new CandidateKey();
        String[][] a = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution.solution(a));
    }
}