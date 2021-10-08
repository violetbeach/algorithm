package kakao;

// 비밀 지도
// String 진수 변환은 알았는데, String.format도 잘 몰랐다. !! 기억

public class SecretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        int len = arr1.length;
        StringBuilder sb = new StringBuilder().append("%").append(len).append("s");
        String s = sb.toString();
        
        for(int i=0; i<len; i++) {
            arr1[i] |= arr2[i];
        }
        
        String[] answer = new String[len];
        for(int i=0; i<len; i++) {
            answer[i] = String.format(sb.toString(), Integer.toBinaryString(arr1[i]));
            answer[i] = answer[i].replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}
