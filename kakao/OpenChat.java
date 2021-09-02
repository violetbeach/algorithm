package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 오픈채팅방
// 아주 효율적인 코드로 잘 짰다.
// 다만, 문제를 제대로 안읽어서 히든 TC통과를 못해서 쩔쩔매다가 힌트 얻고, 쪼금 고쳤던 점..
// 문제를 다 이해하기보다는 일단 틀을 갖춰놓는 것도 좋다고 생각하지만, 그 틀 갖출때도 정성깊게 읽자.
// 그리고 format 같은 것이 정해져있다면, 무언가가 변하지 않는 상수가있다면 유지보수를 위해 전역, 불변 으로 작성하자.

public class OpenChat {
	public String[] solution(String[] record) {
		int len = record.length;
        List<Activity> activities = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        
        for(int i=0; i<len; i++) {
        	String[] arr = record[i].split(" ", 3);
        	if(arr[0].equals("Enter")){
        		hm.put(arr[1], arr[2]);
        		activities.add(new Activity(arr[1], true));
        	} else if(arr[0].equals("Leave")){
        		hm.remove(arr[1]);
        		activities.add(new Activity(arr[1], false));
        	} else if(arr[0].equals("Change")){
        		hm.put(arr[1], arr[2]);
        	}
        }
        
        String[] messages = new String[activities.size()];
        
        int count = 0;
        for(Activity activity : activities) {
        	if(activity.enterOrLeave == true) {
        		messages[count] = hm.get(activity.id) + "님이 들어왔습니다.";
        	} else {
        		messages[count] = hm.get(activity.id) + "님이 나갔습니다.";
        	}
        	count++;
        }
        
        return messages;
    }
	
	public class Activity {
		String id;
		Boolean enterOrLeave;
		
		Activity(String id, Boolean enterOrLeave){
			this.id = id;
			this.enterOrLeave = enterOrLeave;
		}
	}

	public static void main(String[] args) {
		OpenChat a = new OpenChat();
		String[] b = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(a.solution(b));	
	}

}
