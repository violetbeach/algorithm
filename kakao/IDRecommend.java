package kakao;

// 신규 아이디 추천
// 모든 TC는 통과 했지만, 코드가 너무 더럽다.. 보자마자 생각나는게 정규식인데 잘 몰라서 일단은 기본 자료형으로 풀어봤다.
// 이런 식으로 뇌 놓고 코딩하면 늘 배열이나 리스트 인덱스 문제가 발생한다.. 뭐랄까.. 흐름대로 인덱스를 저격하는 식의 코딩을 하지말고
// 우아하게 코드를 짜보자.. 속도도 10배 차이 난다..


/*
 * public class IDRecommend {
 * 
 * static String solution(String new_id) {
 * 
 * String lowStr = new_id.toLowerCase();
 * 
 * StringBuilder str = new StringBuilder(lowStr);
 * 
 * for(int i=0; i<str.length(); i++) { if((str.charAt(i)<48 || str.charAt(i)>57)
 * && (str.charAt(i)<97 || str.charAt(i)>122) && str.charAt(i) != '-' &&
 * str.charAt(i) != '_' && str.charAt(i) != '.') { str = str.deleteCharAt(i);
 * i--; } }
 * 
 * for(int i=0; i<str.length(); i++) { if(str.charAt(i)=='.') {
 * if(i!=str.length()-1 && str.charAt(i+1)=='.') { str = str.deleteCharAt(i);
 * i--; } } }
 * 
 * if(str.toString().equals(".")) return "aaa"; if(str.charAt(0)=='.') str =
 * str.deleteCharAt(0); if(str.charAt(str.length()-1) == '.') str =
 * str.deleteCharAt(str.length()-1);
 * 
 * if(new_id.equals("")) str = str.append('a');
 * 
 * if(str.length()>14) { String temp = str.substring(0, 15); str = new
 * StringBuilder(temp); if(str.charAt(14) == '.') str = str.deleteCharAt(14); }
 * 
 * if(str.length()<=2) { char last = str.charAt(str.length()-1); str =
 * str.append(last); if(str.length()<3) { str = str.append(last); } }
 * 
 * String answer = str.toString();
 * 
 * return answer; }
 * 
 * public static void main(String[] args) {
 * 
 * String new_id = "=.="; System.out.println(solution(new_id)); }
 * 
 * }
 */

public class IDRecommend {
	
	static String solution(String new_id) {
		
		String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }

	public static void main(String[] args) {

		String new_id = "=.=";
		System.out.println(solution(new_id));
	}

}