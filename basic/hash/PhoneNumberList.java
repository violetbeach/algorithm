package basic.hash;

import java.util.HashMap;
import java.util.Map;

// 전화 번호 목록
// 이게 해시 카테고리에 있는데, 해시로 어떻게 해야 효율적일지 전혀 감이 안잡혔다..
// 일단 반복문으로 최대한 간결하게 짰는데 효율성 마지막 TC을 통과하지 못했다..
// 이래가 안된다... 어떻게 저게 이거보다 빠르지.. 검색이 생각보다 훨씬 느리고, 해시는 빠른 것 같다.

/*public class PhoneNumberList {
	
	static boolean solution(String[] phone_book) {
		for(int i=0; i<phone_book.length-1; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
    }

	public static void main(String[] args) {
		
		String[] phone_book = {"123", "456", "789"};

		System.out.println(solution(phone_book));

	}

}*/

public class PhoneNumberList {
	
	static boolean solution(String[] phoneBook) {
		boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }


        for(int i = 0; i < phoneBook.length; i++) {
            for(int j = 0; j < phoneBook[i].length(); j++) {
                if(map.containsKey(phoneBook[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		
		String[] phoneBook = {"123", "456", "789"};

		System.out.println(solution(phoneBook));

	}

}
