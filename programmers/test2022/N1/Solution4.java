package programmers.test2022.N1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution4 {

    int[] dx = {0, 1};
    int[] dy = {1, 0};

    public int solution(int[][] A) {
        int rowLen = A.length;
        int colLen = A[0].length; // TODO 0일 때도 체크

        Set<Country> countries = new HashSet<>();
        Map<Country, Country> tempCountries = new HashMap<>();

        Country[][] B = new Country[rowLen][colLen];

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {

                if(B[i][j] != null) {
                    while(true) {
                        if(tempCountries.containsKey(B[i][j])) {
                            B[i][j] = tempCountries.get(B[i][j]);
                        } else {
                            break;
                        }
                    }
                }

                if(B[i][j] == null) {
                    Country country = new Country();
                    B[i][j] = country;
                    countries.add(country);
                };

                for(int k = 0; k < 2; k++) {
                    int newRow = i + dy[k];
                    int newCol = j + dx[k];

                    if(newRow < rowLen - 1 && newCol < colLen - 1) {
                        if(A[i][j] == A[newRow][newCol]) {
                            if(B[newRow][newCol] == null) {
                                B[newRow][newCol] = B[i][j];
                            } else {
                                countries.remove(B[i][j]);
                                tempCountries.put(B[i][j], B[newRow][newCol]);
                                B[i][j] = B[newRow][newCol];
                            }
                        }
                    }
                }

            }
        }

        return countries.size();
    }

    static class Country {

    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] a = {{}};
        System.out.println(solution4.solution(a));
    }
}
