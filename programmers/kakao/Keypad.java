package kakao;

// 키패드
// 다른 사람꺼 보니까 필드변수랑 로컬변수랑 분리해서 짰다.
// 너무 훌륭하다. 나도 저렇게 해서 짜고 테스트코드로 실행하자.

public class Keypad {
	
	/*
	 * public static String solution(int[] numbers, String hand) { StringBuilder sb
	 * = new StringBuilder(); int[] lo = new int[2];
	 * 
	 * for(int n : numbers) { if(n%3 == 1) { sb.append("L"); lo[0] = n; } else
	 * if(n%3 == 2 || n == 0) { if(lo[0] > lo[1]) { sb.append("L"); lo[0] = n; }
	 * else if(lo[0] < lo[1]) { sb.append("R"); lo[0] = n; } else { if(hand ==
	 * "left") { sb.append("L"); lo[0] = n; } else { sb.append("R"); lo[1] = n; } }
	 * } else { sb.append("R"); lo[1] = n-2; } }
	 * 
	 * return sb.toString(); }
	 * 
	 * public static void main(String[] args) { int[] a = {1, 3, 4, 5, 8, 2, 1, 4,
	 * 5, 9, 5}; String b = "right"; System.out.println(solution(a, b)); }
	 */
	
	int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;
    public String solution(int[] numbers, String hand) {
        this.hand = (hand.equals("right")) ? "R" : "L";

        String answer = "";
        for (int num : numbers) {
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
        }
        return answer;
    }

    //num버튼을 누를 때 어디 손을 사용하는가
    private String pushNumber(int num) {
        if(num==1 || num==4 || num==7) return "L";
        if(num==3 || num==6 || num==9) return "R";

        // 2,5,8,0 일때 어디 손가락이 가까운가
        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

        //같으면 손잡이
        return this.hand;
    }

    //해당 위치와 번호 위치의 거리
    private int getDist(int[] pos, int num) {
        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
    
}
