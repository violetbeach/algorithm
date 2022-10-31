// 파라메트릭 서치

class ParametricSearch {

    static boolean[] arr;

    static int parametricSearch(int s, int e){

        int maxIndex = -1;

        while(s<=e){
            int mid = (s+e)/2;
            boolean mVal = arr[mid];

            if (mVal) {
                if (maxIndex < mid) maxIndex = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return maxIndex;

    }

}