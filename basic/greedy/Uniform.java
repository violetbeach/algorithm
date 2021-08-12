package basic.greedy;

// 체육복
// 일단 코드가 복잡하다. 정수 배열은 초기화를 해주지 않아도 된다. 굳이 값이 0 이상일 이유는 없다.
// 예외처리가 부족하다. 배열 인덱스 -1이나 초과를 해버릴 수 있는 코드를 만들었다.
// 논리는 같은 논리라 다른 사람 코드를 보고 내 코드만 조금 다듬었다.

/*
 * public class Uniform {
 * 
 * public static int solution(int n, int[] lost, int[] reserve) { int[] stud =
 * new int[n];
 * 
 * for(int i=0; i<n; i++) { stud[i] = 1; }
 * 
 * for(int k : reserve) { stud[k-1] = 2; }
 * 
 * for(int j : lost) { stud[j-1]=0; if(stud[j-2]==2) { stud[j-2]--; stud[j-1]++;
 * } else if (stud[j]==2) { stud[j]--; stud[j-1]++; } } int answer = 0; for(int
 * l=0; l<n; l++) if(stud[l] >= 1) answer++; return answer++; }
 * 
 * public static void main(String[] args) {
 * 
 * int n = 5; int[] lost = {2,4}; int[] reserve = {1,3,5};
 * System.out.println(solution(n, lost, reserve)); }
 * 
 * }
 */

public class Uniform {
	
	static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }

	public static void main(String[] args) {

		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
		System.out.println(solution(n, lost, reserve));
	}

}