package basic.greedy;

import java.util.Stack;

// 큰수 만들기
// 스택을 사용하는 문제였다.. 그리디라는 카텥고리에 있어서 너무 고정관념에 잡혀있었다.
// 그냥 풀어서는 10번 TC가 시간초과 였다..
// 실제로는 카테고리가 없으니 넓게 생각하자.

/*
 * public class MakeBigNumber {
 * 
 * static String solution(String number, int k) { String answer = "";
 * StringBuilder sb = new StringBuilder();
 * 
 * int i=0; while(true) {
 * 
 * if(i+1<number.length() && number.charAt(i) < number.charAt(i+1) && k>0) {
 * k--; } else { sb.append(number.charAt(i)); }
 * 
 * i++;
 * 
 * if(k<=0 && i==number.length()) return sb.toString();
 * 
 * if(i==number.length()) break;
 * 
 * }
 * 
 * sb.delete(sb.length()-k, sb.length());
 * 
 * return sb.toString(); }
 * 
 * 
 * public static void main(String[] args) { String number = "1924"; int k = 2;
 * System.out.println(solution(number, k)); }
 * 
 * }
 */

class MakeBigNumber {
	
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
    
}
