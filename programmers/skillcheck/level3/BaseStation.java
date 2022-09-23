package skillcheck.level3;

/*
* 기지국 설치
*
* 시행착오를 너무 많이 겪었다.
* - 점화식은 충분히 검증한 후 메서드에 그냥 박아넣자. (나중에 까먹는다.)
*   - 한번 실수하면 너무 돌아간다... 신중하게 해야한다.
*   - 주석을 남기는 것도 좋을 것 같다. 주석이 없으니 변수 의미가 너무 두루뭉실하고 실수가 발생한다.
* - 문제를 많이 풀자.
* - 추가로 Programmers에 테스트 케이스를 추가할 수 있는 부분이 생긴 것 같다.
* - 시간이 남으면 TC를 많이 추가하자.
* 결과물은 잘나왔다.
* */

public class BaseStation {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int prev = 0;
        for(int i = 0; i < stations.length; i++) {
            answer += getNeed(w, prev, stations[i] - w);

            prev = stations[i] + w;
        }

        if(prev < n) {
            answer += getNeed(w, prev, n + 1);
        }

        return answer;
    }

    private int getNeed(int w, int prev, int current) {
        int noSupport = current - prev - 1;

        if(noSupport < 0) {
            return 0;
        }

        int need = noSupport / getRange(w);
        if(noSupport % getRange(w) != 0) {
            need++;
        }

        return need;
    }

    private int getRange(int w) {
        return (w * 2) + 1;
    }

}
