// 순열

public class Permutation {

    static int[] arr;
    static boolean[] visited;

    static void permutation(int[] output, int depth, int n, int r){
        if(depth==r){
            // 순열이 완성되었음
            // -> 처리하는 로직
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(output,depth+1,n,r);
                visited[i]=false;
            }
        }
    }

}
