import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution4 {

    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};

    public int solution(int[][] A) {
        int rowLen = A.length;
        int colLen = A[0].length;

        Set<Point> points = new HashSet<>();
        Map<Point, Point> union = new HashMap<>();

        Point[][] B = new Point[rowLen][colLen];

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {

                if(B[i][j] != null) {
                    while(true) {
                        if(union.containsKey(B[i][j])) {
                            B[i][j] = union.get(B[i][j]);
                        } else {
                            break;
                        }
                    }
                }

                if(B[i][j] == null) {
                    Point point = new Point();
                    B[i][j] = point;
                    points.add(point);
                };

                for(int k = 0; k < 2; k++) {
                    int newRow = i + dy[k];
                    int newCol = j + dx[k];

                    if(newRow < rowLen - 1 && newCol < colLen - 1) {
                        if(A[i][j] == A[newRow][newCol]) {
                            points.remove(B[i][j]);
                            union.put(B[i][j], B[newRow][newCol]);
                            B[i][j] = B[newRow][newCol];
                        }
                    }
                }

            }
        }

        return points.size();
    }

    static class Point {

    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] A = {{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
        System.out.println(solution4.solution(A));
    }

}
