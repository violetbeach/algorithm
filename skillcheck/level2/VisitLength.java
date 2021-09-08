package skillcheck.level2;

// 방문 길이
// 중복 검사가 Set으로 안되는 array 등이라면 boolean으로 검사하자.
// 반복으로 안찾아도 되고 값만 하나씩 올려도 되는경우 아주 좋음.

// KISS원칙에 명백히 어긋난다. 다음엔 U,D,R,L만 넣을 게 아니라 map으로 해서 반응까지 같이 넣어주거나
// int배열하나 UDRL하나 해서 유기적으로 처리하자.

public class VisitLength {
	
	private final static char[] controll = {'U', 'D', 'R', 'L'};
	
	public int solution(String dirs) {
		int answer = 0;
        boolean[][][][] check = new boolean[11][11][11][11];
        
        int x = 5;
        int y = 5;
        
        for(char c : dirs.toCharArray()) {
        	if(c==controll[0] && y!=10) {
        		if(!check[x][y][x][y+1]) {
        			check[x][y][x][y+1] = true;
        			check[x][y+1][x][y] = true;
        			answer++;
        		}
        		y++;
        	} else if(c==controll[1] && y!=0) {
        		if(!check[x][y][x][y-1]) {
        		check[x][y][x][y-1] = true;
        		check[x][y-1][x][y] = true;
        		answer++;
        		}
        		y--;
        	} else if(c==controll[2] && x!=10) {
        		if(!check[x][y][x+1][y]) {
        			check[x+1][y][x][y] = true;
            		check[x][y][x+1][y] = true;
            		answer++;
        		}
        		x++;
        	} else if(c==controll[3] && x!=0) {
        		if(!check[x][y][x-1][y]){
        			check[x][y][x-1][y] = true;
            		check[x-1][y][x][y] = true;
            		answer++;
            		}
            	x--;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		VisitLength a = new VisitLength();
		System.out.println(a.solution("ULURRDLLU"));
	}

}
