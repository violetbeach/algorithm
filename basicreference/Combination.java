/*
* 조합
*
* start를 1씩 올리기에 중복이 사라짐
*
* 포함하는 원소의 개수가 다름 (1, 12, 123 등)
*
* */

/*public static void main(String[] args) {
        int arr[]={1,2,3,4};
        boolean visited[]=new boolean[arr.length];
        for(int i=0;i<arr.length;i++){
            combination(arr,visited,0,arr.length,i+1);
        }
}*/

public class Combination {

    static void combination(int arr[], boolean visited[], int start, int n, int r){
        if(r==0){
            // 조합이 완성되었음
            // (visited를 순회하면서 arr에서 꺼내야 함)
            // -> 처리하는 로직
            return;
        }

        for(int i=start;i<n;i++){
            visited[i]=true;
            combination(arr,visited,i+1,n,r-1);
            visited[i]=false;
        }
    }

}
