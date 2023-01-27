package codebattle;

import java.util.*;

/*
* 정확도는 100이지만, 15번째 TC에서 시간초과가 발생했다.
*
* 내가 작성한 코드는 updateTeam을 제외하고 O(1)이다.
* updateTeam은 Set을 복사해서 그대로 옮겨주기만 해서 O(n)보다 빠를 것이라고 기대했다. (확실히 몰랐다.)
*
* 추가로 문제에는 내가 읽지못한 빨간 글씨로 강조된 부분이 있었다.
* - 각 테스트 케이스에서 bestSolution() 함수의 호출 횟수는 100 이하이다. (다른 함수는 100,000 이하)
*
* [알게된 사실]
* 1. Set, List 등을 전체 복사하든 옮기든 시간복잡도는 O(n)이다.
*   - 얕은 복사: O(1), 깊은 복사: O(n)
* 2. LinkedList를 사용하면 그룹을 통째로 옮길 때 O(1)에 처리할 수 있다. -> 탐색(O(n))이 중요하지 않는 경우 적용 가능
*   - 유일하게 LinkedList만 가능한 것 같다.
* 3. LinkedList를 사용하면 탐색이 O(n)이 걸리지만, 문제에서 탐색의 함수의 호출 횟수는 100 이하라고 명시를 했기 때문에 정답이 되었다.
* 4. 자료구조를 잘 사용하면 모든 케이스에서 최적의 솔루션을 찾을 수 있다고 생각하고 있었던 것은 착각이었다. (반드시 Trade-Off가 따라야 했다.)
*
* 결론) 많이 배웠다.
*   - 내 풀이가 완전 잘못된 것은 아닌듯 하다.
*   - deepCopy에서 시간복잡도를 정확하게 파악하지 못했다.
*   - 문제의 설명(각 함수 호출 횟수)이 의미하는 바를 정확히 파악하지 못했다.
*      - 100000 * 100은 3초 이내에 충분히 처리할 수 있었다고 한다.
* */

class UserSolution
{
    int[] teamByUsers = new int[100001];

    SortedSet<Integer>[][] usersByTeamAndScore;

    public void init()
    {
        usersByTeamAndScore = new TreeSet[6][6];
        for(int i = 1; i <= 5; i++) {

            for(int j = 1; j <= 5; j++) {
                usersByTeamAndScore[i][j] = new TreeSet<>();
            }
        }
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        teamByUsers[mID] = mTeam;

        usersByTeamAndScore[mTeam][mScore].add(mID);
    }

    public void fire(int mID)
    {
        int i = teamByUsers[mID];
        for(int j = 1; j <= 5; j++) {
            if(usersByTeamAndScore[i][j].remove(mID)) {
                break;
            }
        }
    }

    public void updateSoldier(int mID, int mScore)
    {
        int i = teamByUsers[mID];
        for(int j = 1; j <= 5; j++) {
            if(usersByTeamAndScore[i][j].remove(mID)) {
                break;
            }
        }
        usersByTeamAndScore[i][mScore].add(mID);

    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        if(mChangeScore < 0) {
            for(int i = 2; i <= 5; i++) {
                int expected = changeScorePerTeam(i, mChangeScore);
                if(i != expected) {
                    usersByTeamAndScore[mTeam][expected].addAll(usersByTeamAndScore[mTeam][i]);
                    usersByTeamAndScore[mTeam][i].clear();
                }
            }
        }

        if(mChangeScore > 0) {
            for(int i = 4; i >= 1; i--) {
                int expected = changeScorePerTeam(i, mChangeScore);
                if(i != expected) {
                    usersByTeamAndScore[mTeam][expected].addAll(usersByTeamAndScore[mTeam][i]);
                    usersByTeamAndScore[mTeam][i].clear();
                }
            }
        }
    }

    public int bestSoldier(int mTeam)
    {
        for(int i = 5; i > 0; i--) {
            if(!usersByTeamAndScore[mTeam][i].isEmpty()) {
                return usersByTeamAndScore[mTeam][i].last();
            }
        }

        return 0;
    }

    private int changeScorePerTeam(int cur, int mChangeScore) {
        if(cur + mChangeScore > 5) {
            return 5;
        }
        if(cur + mChangeScore < 1) {
            return 1;
        }
        return cur + mChangeScore;
    }
}