package kakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 외벽 점검
 *
 * 그리디로 풀다가 정확성이 깨졌다. 완전탐색을 수행했어야 헀다.
 * - (카운트와 거리가 동일하더라도 두 경로가 있을 때 선택에 따라 결과가 달라짐)
 * - 아래 참조 https://dev-note-97.tistory.com/241
 *
 * 원형을 다루는 게 어색했었는데, 해당 크기만큼 배열로 원소를 추가로 만들어서 돌려주면 되었다.
 *
 * + 문제 생긴게 이분탐색처럼 생겼다고 생각했었는데 오해였다.
 *
 * 순열은 남자답게 구현하면 풀린다. (깊은 복사 사용해야 한다.)
 *
 * */
public class CheckWall {

    List<int[]> per = new ArrayList<>();
    int[] dists;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        int wLength = weak.length;
        int dLength = dist.length;
        int[][] weaks = new int[weak.length][weak.length];

        for(int i = 0; i < wLength; i++) {
            for(int j = 0; j < wLength; j++) {
                weaks[i][j] = i + j >= wLength ? n + weak[(i+j) % wLength] : weak[i+j];
            }
        }

        dists = dist;
        boolean[] visited = new boolean[dLength];

        initOrder(dLength, visited, 0, new int[dLength]);

        for(int i = 0; i < wLength; i++) {
            for(int j = 0; j < per.size(); j++) {
                check(weaks[i], per.get(j));
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    void check(int[] weaks, int[] dists) {
        int dCount = 0;
        int pointer = 0;
        for(int i = 0; i < weaks.length; i++) {
            if(pointer > weaks[i]) {
                continue;
            }
            if(dCount == dists.length) {
                break;
            }
            pointer = weaks[i];
            pointer += dists[dCount++] + 1;
        }
        if(pointer > weaks[weaks.length-1]) {
            answer = Math.min(answer, dCount);
        }
    }

    void initOrder(int n, boolean[] visited, int idx, int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        if(idx == n) {
            per.add(arr);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                newArr[idx] = dists[i];
                initOrder(n, visited, idx+1, newArr);
                visited[i] = false;
            }
        }
    }

    @Test
    void test() {
        int n = 5;
        int[] weak = {1, 3, 5};
        int[] dist = {1, 1};

        int solution = solution(n, weak, dist);
        Assertions.assertEquals(solution,2);
    }

}

/*class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        List<Place> places = new ArrayList<>();

        Set<Integer> weakSet = new HashSet<>();
        for(int i : weak) {
            weakSet.add(i);
        }

        List<Integer> dists = new ArrayList<>();
        for(int i : dist) {
            dists.add(i);
        }

        for(int i = 0; i <weak.length; i++) {
            int a = weak[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i; j<weak.length; j++) {
                int b = weak[j];
                set.add(b);

                int min = Math.min(a, b);
                int max = Math.max(a, b);

                Place place = new Place(max - min, Set.copyOf(set));
                places.add(place);
            }

            if(a > n/2) continue;
            set = new HashSet<>();
            for(int j = i; j>i-weak.length; j--) {
                int b = 0;
                if(j >= 0) b = weak[j];
                if(j < 0) b = weak[weak.length + j];
                set.add(b);

                int min = Math.min(a, b);
                int max = Math.max(a, b);

                Place place = new Place(n - max + min, Set.copyOf(set));
                places.add(place);
            }
        }

        Comparator<Place> comparator = (a, b) -> {
            int compare = Integer.compare(b.count, a.count);
            if(compare == 0) compare = Integer.compare(a.distance, b.distance);
            return compare;
        };

        places.sort(comparator);
        dists.sort(Collections.reverseOrder());

        int answer = 0;

        for(Place p : places) {
            if(weakSet.size() <= 0) {
                break;
            }

            if(dists.size() <= 0) {
                return -1;
            }

            boolean match = weakSet.containsAll(p.set);
            if(!match) continue;

            Integer d = dists.get(0);
            if(d < p.distance) continue;

            int i = 0;
            while(dists.size() > i+1 && dists.get(i+1) >= p.distance) {
                d = dists.get(++i);
            }

            weakSet.removeAll(p.set);
            dists.remove(i);
            answer++;
        }



        return answer;
    }

    class Place {
        public int distance;
        public int count;
        Set<Integer> set;

        public Place(int distance, Set<Integer> set) {
            this.distance = distance;
            this.count = set.size();
            this.set = set;
        }
    }

}*/
