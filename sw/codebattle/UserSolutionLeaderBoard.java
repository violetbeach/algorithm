package codebattle;

import java.util.*;

class UserSolutionLeaderBoard
{
    Set<Integer>[] userIdsByTeam;
    Map<Integer, Integer> mScoreMap;
    Queue<Integer>[][] leaderBoard;

    public void init()
    {
        userIdsByTeam = new HashSet[6];
        leaderBoard = new PriorityQueue[6][6];
        for(int i = 1; i <= 5; i++) {
            userIdsByTeam[i] = new HashSet<>();
            for(int j = 1; j <= 5; j++) {
                leaderBoard[i][j] = new PriorityQueue<>(Collections.reverseOrder());
            }
        }

        mScoreMap = new HashMap<>();
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        Set<Integer> usersByTeam = userIdsByTeam[mTeam];
        usersByTeam.add(mID);

        mScoreMap.put(mID, mScore);

        leaderBoard[mTeam][mScore].add(mID);
    }

    public void fire(int mID)
    {
        for(int i = 1; i <= 5; i++) {
            Set<Integer> usersByTeam = userIdsByTeam[i];
            if(usersByTeam.remove(mID)) {
                leaderBoard[i][mScoreMap.get(mID)].remove(mID);
                break;
            }
        }
        mScoreMap.remove(mID);
    }

    public void updateSoldier(int mID, int mScore)
    {
        for(int i = 1; i <= 5; i++) {
            Set<Integer> usersByTeam = userIdsByTeam[i];
            if(usersByTeam.remove(mID)) {
                leaderBoard[i][mScoreMap.get(mID)].remove(mID);
                break;
            }
        }
        mScoreMap.put(mID, mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        Set<Integer> mIDs = userIdsByTeam[mTeam];
        for(Integer mID : mIDs) {
            Integer score = mScoreMap.get(mID);
            int expect = changeScorePerTeam(score, mChangeScore);

            mScoreMap.put(mID, expect);
            leaderBoard[mTeam][score].remove(mID);
            leaderBoard[mTeam][expect].add(mID);
        }
    }

    public int bestSoldier(int mTeam)
    {
        for(int i = 5; i > 0; i--) {
            if(!leaderBoard[mTeam][i].isEmpty()) {
                return leaderBoard[mTeam][i].peek();
            }
        }
        return 0;
    }

    /*class Soldier implements Comparable<Soldier> {
        private int mId;
        private int mScore;

        public Soldier(int mId, int mScore) {
            this.mId = mId;
            this.mScore = mScore;
        }

        public int getmId() {
            return mId;
        }

        public void setmScore(int mScore) {
            this.mScore = mScore;
        }

        private void changeScorePerTeam(int mChangeScore) {
            if(mScore + mChangeScore > 5) {
                mScore = 5;
                return;
            }
            if(mScore + mChangeScore < 1) {
                mScore = 1;
                return;
            }
            mScore += mChangeScore;
        }

        @Override
        public int compareTo(Soldier o) {
            int result = Integer.compare(o.mScore, mScore);
            if (result == 0) {
                result = Integer.compare(o.mId, mId);
            }
            return result;
        }
    }*/
    private int changeScorePerTeam(int score, int mChangeScore) {
        if(score + mChangeScore > 5) {
            return 5;
        }
        if(score + mChangeScore < 1) {
            return 1;
        }
        return score + mChangeScore;
    }
}