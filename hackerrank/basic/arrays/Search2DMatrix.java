package basic.arrays;

// 2차원 행렬 펴는게 더 오래걸리니까, 행과 열에 둘다 이분 탐색해야함.

public class Search2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
		for(int i=0; i<matrix.length; i++){
            if(i+1 < matrix.length && target >= matrix[i+1][0]){
                continue;
            } else {
                int start = 0;
                int end = matrix[0].length-1;
                while(start <= end){
                    int mid = (end + start)/2;
                    if(target == matrix[i][mid]) return true;
                    if(target > matrix[i][mid]) start = mid+1;
                    else end = mid-1;
                }
                return false;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Search2DMatrix a = new Search2DMatrix();
		int[][] b = {{1}};
		System.out.println(a.searchMatrix(b, 2));

	}

}
