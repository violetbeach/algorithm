package kakao;

import java.util.Arrays;
import java.util.Comparator;

// 파일명 정렬
// 너무 지저분하다. 코드를 정렬하자. 반복문 i 같은거 재사용 하지말고, 두개 만들고 두개 돌리고 이런식으로 하자.

// String head1 = sb1.substring(0, i);
// String head2 = sb2.substring(0, i);
// if(head1.compareTo(head2) !=0) return head1.compareTo(head2); // 이렇게 하면, 같은 함수가 두번 나옴, 안좋음. 아래처럼 수정

// int cmp = sb1.substring(0, i).compareTo(sb2.substring(0, j));
// if(cmp !=0 ) return cmp;

// 퍼포먼스는 잘짰음. 위치만 찾는거기 때문에 정규식이 안좋음.

public class FileSort {
	public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // sb를 사용해서 구현, 전부 대문자로 비교함.
                StringBuilder sb1 = new StringBuilder(s1.toUpperCase());
                StringBuilder sb2 = new StringBuilder(s2.toUpperCase());
                int i = 0;
                while(!Character.isDigit(sb1.charAt(i))) {
                    i++;
                }
                String head1 = sb1.substring(0, i);
                i = 0;
                while(!Character.isDigit(sb2.charAt(i))) {
                    i++;
                }
                String head2 = sb2.substring(0, i);
                
                if(head1.compareTo(head2) !=0) return head1.compareTo(head2);
                else {
                    int temp = i;
                    while(temp < sb1.length() && Character.isDigit(sb1.charAt(temp))) {
                        temp++;
                    }
                    int number1 = Integer.parseInt(sb1.substring(i, temp));
                    temp = i;
                    while(temp < sb2.length() && Character.isDigit(sb2.charAt(temp))) {
                        temp++;
                    }
                    int number2 = Integer.parseInt(sb2.substring(i, temp));
                    
                    return Integer.compare(number1, number2);
                }
                
            }
        });
            
        return files;
    }
	
public static void main(String[] args) {
		
		FileSort a = new FileSort();
		String[] b = {"img000012345", "img1.png","img2","IMG02"};
		System.out.println(a.solution(b));	
	}
}
