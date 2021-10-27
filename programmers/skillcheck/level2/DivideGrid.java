package skillcheck.level2;

// 전력망 둘로 나누기
// Union-Find

public class DivideGrid {
	static int[] parents;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        int idx =0;
        parents = new int[n+1];
        while(idx < n-1) {
            for(int i=1; i<n+1; i++) {
                parents[i] =i;
            }

            for(int i=0; i<wires.length; i++) {
                if(idx == i) continue;

                int a = wires[i][0];
                int b = wires[i][1];

                union(a,b);
            }


            int tmp =0;
            for(int i=1; i<n+1; i++) {
                if(find(parents[i]) == 1) tmp++;
            }
            int res = Math.abs(n-2*tmp);

            answer = Math.min(res, answer);
            idx++;
        }

        return answer;
    }

    static int find(int x) {
        if(parents[x] ==x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if(ry < rx) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }

        if(rx!=ry) {
            parents[ry]= rx;
        }
    }
}
