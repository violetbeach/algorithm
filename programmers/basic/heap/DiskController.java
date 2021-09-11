package basic.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

// 디스크 컨트롤러
// 운영체제 SJF 알고리즘 구현 문제
// 대기큐, 작업큐를 따로 구현
// 대기큐를 굳이 큐를 쓸 필요 없었음. 추가는 없기 때문 (배열 하나 큐 하나가 더 좋음. 생성, 변환할 필요 없었음)

public class DiskController {
	
	public static void main(String[] args) {
		DiskController a = new DiskController();
		int[][] b = {{0,300}, {1,9},{2,6}};
		System.out.println(a.solution(b));	
	}
	
	class Job {
        int requestTime;
        int workingTime;
        
        Job(int requestTime, int workingTime){
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }
	
	public int solution(int[][] jobs) {
		LinkedList<Job> waiting = new LinkedList<>();
    	PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
    		@Override
    		public int compare(Job j1, Job j2) {
    			return j1.workingTime - j2.workingTime;
    		}
    	});
    	
    	for(int[] job : jobs) {
    		waiting.offer(new Job(job[0], job[1]));
    	}
    	
    	Collections.sort(waiting, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return j1.requestTime - j2.requestTime;
			}
    	});
    	
    	int answer = 0;
    	int cnt = 0;
    	int time = waiting.peek().requestTime;

    	while(cnt < jobs.length) {
    		while(!waiting.isEmpty() && waiting.peek().requestTime <= time) {
    			pq.offer(waiting.pollFirst());
    		}
    		
    		if(!pq.isEmpty()) {
    			Job job = pq.poll();
    			time += job.workingTime;
    			answer += time - job.requestTime;
    			cnt++;
    		} else {
    			time = waiting.peek().requestTime;
    		}
    	}
    	
    	return answer / cnt;
    }


}
