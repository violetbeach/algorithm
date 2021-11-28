package programmers.basic.hash;

import java.util.*;

// 베스트앨범
// 리스트를 배열에 옮길 때 stream().mapToInt(i->i).toArray(); 이거보다 for문이 훨~~~씬 빠르다.
// TC 9번에러만 실패해서 4시간 정도 찾았다. 로컬변수 초기화 시점이 잘못됐다. 너무 급했나... 습관을 잘들이자.

public class BestAlbum {
	public int[] solution(String[] genres, int[] plays) {
		int len = plays.length;
        HashMap<String, Integer> genrePlay = new HashMap<>();
        HashMap<String, List<Sing>> songs = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        // 해시맵에 장르당 재생수, 노래당 재생수 추가
        for(int i=0; i<len; i++) {
        	List<Sing> s = new ArrayList<>();
        	if(songs.containsKey(genres[i])) {
        		s = songs.get(genres[i]);
        	}
        	s.add(new Sing(i, plays[i]));
        	songs.put(genres[i], s);
        	genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keySetList = new ArrayList<>(genrePlay.keySet());
        Collections.sort(keySetList, (o1, o2) -> (genrePlay.get(o2).compareTo(genrePlay.get(o1))));
        
        int max = 0;
        for(String key : keySetList) {
        	List<Sing> l = songs.get(key);
        	Collections.sort(l);
        	for(Sing s : l) {
        		System.out.println(s.play);
        		answer.add(s.id);
        		max++;
        		if(max > 1) {
        			max = 0;
        			break;
        		}
        	}
        }
        
        int[] bb = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            bb[i] = answer.get(i).intValue();
        }
        
        return bb;
    }
	
	public static List<String> sortByValue(final Map<String, Integer> map) {
        List<String> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list,new Comparator<Object>() {

			@Override
            public int compare(Object key1, Object key2) {
                if ( map.get(key1) > map.get(key2) ) return -1;
                else if ( map.get(key1) == map.get(key2) ) return 0;
                else return 1;
            }
        });

        return list;
    }
	
	class Sing implements Comparable<Sing>{
		int id;
		int play;
		
		Sing(int id, int play){
			this.id = id;
			this.play = play;
		}
		
		@Override
		public int compareTo(Sing s) {
			if(play < s.play) return 1;
			else if(play > s.play) return -1;
			else return 0;
		}
		
	}
	
	public static void main(String[] args) {
		BestAlbum a = new BestAlbum();
		String[] b = {"classic", "pop", "classic", "classic", "pop"};
		int[] c = {500, 600, 150, 800, 2500};
		System.out.println(a.solution(b, c));	
	}
}