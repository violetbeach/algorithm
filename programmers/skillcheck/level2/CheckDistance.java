package skillcheck.level2;

/*
* 거리두기 확인하기
*
* 어렵게 머리안쓰고 경우의수를 풀어내는 것도 방법이다!
* */

class CheckDistance {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            String[] temp = places[i];
            boolean check = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (temp[j].charAt(k) == 'P') {
                        if(search(j, k, temp)) {
                            check = true;
                        }
                    }
                }
            }
            answer[i] = check ? 0 : 1;
        }
        return answer;
    }
    static boolean search(int x, int y, String[] temp) {
        // 상하좌우 확인
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }
            if (temp[nx].charAt(ny) == 'P') {
                return true;
            }
        }

        // 거리 2인 경우 확인
        int[] dx2 = {0, 0, 2, -2};
        int[] dy2 = {2, -2, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }
            if (temp[nx].charAt(ny) == 'P') {
                // 둘 사이에 X가 없다면
                if (temp[x + dx2[i] / 2].charAt(y + dy2[i] / 2) != 'X') {
                    return true;
                }
            }
        }

        // 대각선 확인
        int[] dx3 = {1, 1, -1, -1};
        int[] dy3 = {1, -1, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx3[i];
            int ny = y + dy3[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }
            if (temp[nx].charAt(ny) == 'P') {
                // p위치에 맞는 상하좌우에 X가 없다면
                if (!(temp[x].charAt(ny) == 'X' && temp[nx].charAt(y) == 'X')) {
                    return true;
                }
            }
        }
        return false;
    }
}