package kakao;

// 추석 트래픽

// 잘풀었지만, 24*60*60 이런 식보다는 getTime()읊 사용했으면 됐다.
// (hh:mm:ss.SSS로 format 후 출력했을 때 mil이 안나와서 포기했는데, 출력만 안되고 안에 저장은 되어 있었다)

// 다음 주에 날잡아서 Date API를 공부하자!

class MaxTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        Traffic arr[] = new Traffic[lines.length];
        for(int i=0; i<lines.length; i++){
            arr[i] = str2time(lines[i]);
        }

        for(int i=0; i<arr.length; i++){
            answer = Math.max(answer, count(arr[i].start, arr, i));
            answer = Math.max(answer, count(arr[i].end, arr, i));
        }

        return answer;
    }

    static int count(int start, Traffic[] arr, int i){
        int end = start + 1000;
        int cnt = 1;
        for(int j=0; j<arr.length; j++){
            if(i==j) continue;
            if( arr[j].end < start || arr[j].start >= end ) continue;
            cnt++;
        }
        return cnt;
    }

    static Traffic str2time(String str){
        String[] temp = str.split(" ");

        String[] tmp = temp[1].split(":");
        int hour = Integer.parseInt(tmp[0])*60*60*1000;
        int min = Integer.parseInt(tmp[1])*60*1000;
        int sec = Integer.parseInt(tmp[2].substring(0,2))*1000 + Integer.parseInt(tmp[2].substring(3,6));

        int calTime = 0;
        if(temp[2].length()> 2){
            calTime = Integer.parseInt(temp[2].substring(0,1))*1000 + Integer.parseInt(temp[2].substring(2,temp[2].length()-1));
        }else{
            calTime = Integer.parseInt(temp[2].substring(0,1))*1000;
        }

        int end = hour+min+sec;
        int start = end - calTime +1;

        return new Traffic(start, end);
    }

    static class Traffic {
        int start;
        int end;
        Traffic(int a, int b){
            this.start = a;
            this.end = b;
        }
    }
}