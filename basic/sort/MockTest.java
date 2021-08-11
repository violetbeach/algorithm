package basic.sort;

import java.util.ArrayList;

// 모의고사
// 처리가 너무... 길고 .. 불편하다..
// 다른 사람은 훨씬 우아하게 짰다.. 원리는 똑같다. (마지막 return 문에서는 매우 간결한 대신 오래 걸린다고 함)

/*public class MockTest {
	
	public static int[] solution(int[] answers) {
		
		int[] resA = new int[answers.length];
		int[] resB = new int[answers.length];
		int[] resC = new int[answers.length];
		
		for(int i=0; i<answers.length; i++) {
			
			switch(i%5){
			case 0: 
				resA[i]=1;
				break;
			case 1:
				resA[i]=2;
				break;
			case 2:
				resA[i]=3;
				break;
			case 3:
				resA[i]=4;
				break;
			case 4:
				resA[i]=5;
				break;
			}
			
			switch(i%8){
			case 0: 
				resB[i]=2;
				break;
			case 1:
				resB[i]=1;
				break;
			case 2:
				resB[i]=2;
				break;
			case 3:
				resB[i]=3;
				break;
			case 4:
				resB[i]=2;
				break;
			case 5:
				resB[i]=4;
				break;
			case 6:
				resB[i]=2;
				break;
			case 7:
				resB[i]=5;
				break;
			}
			
			switch(i%10){
			case 0: 
				resC[i]=3;
				break;
			case 1:
				resC[i]=3;
				break;
			case 2:
				resC[i]=1;
				break;
			case 3:
				resC[i]=1;
				break;
			case 4:
				resC[i]=2;
				break;
			case 5: 
				resC[i]=2;
				break;
			case 6:
				resC[i]=4;
				break;
			case 7:
				resC[i]=4;
				break;
			case 8:
				resC[i]=5;
				break;
			case 9:
				resC[i]=5;
				break;
			}
		}
		
		int[] count = {0, 0, 0};
		
		for(int i=0; i<answers.length; i++) {
			if(resA[i] == answers[i]) {
				count[0]++;
			}
			if(resB[i] == answers[i]) {
				count[1]++;
			}
			if(resB[i] == answers[i]) {
				count[2]++;
			}
		}
        
        List<Integer> maxRes = new ArrayList<>();
        
        int max = 0;
        for(int i : count) {
        	if(i>max) max = i;
        }
        
        if(count[0]==max) {
        	maxRes.add(1);
        }
        
        if(count[1]==max) {
        	maxRes.add(2);
        }
        
        if(count[2]==max) {
        	maxRes.add(3);
        }
        
        int[] answer = new int[maxRes.size()];
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = maxRes.get(i);
        }
        
        return answer;
    }

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(solution(arr)[0]);
		
	}

}*/

public class MockTest {
	
	public static int[] solution(int[] answers) {
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] score = new int[3];
		for(int i=0; i<answers.length; i++) {
			if(answers[i] == a[i%a.length]) score[0]++;
			if(answers[i] == b[i%b.length]) score[1]++;
			if(answers[i] == c[i%c.length]) score[2]++;
		}
		
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i).toArray();
    }

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(solution(arr)[0]);
		
	}

}
