package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Professional {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static char[] s1, s2;


    public static void main(String[] args) throws IOException {
        int test = Integer.parseInt(br.readLine());
        for (int t=1; t<=test; t++) {
            s1 = br.readLine().toCharArray();
            s2 = br.readLine().toCharArray();

//			 makeFail();


            sb.append("#").append(t).append(" ").append(findString()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static int findString() {
        int answer = 0;

        long parentHash = 0, patternHash = 0, pow = 1;
        long D = 257;

        for (int i=0; i<=s1.length-s2.length; i++) {
            if (i == 0) {
                for (int j=0; j<s2.length; j++) {
                    parentHash += s1[s2.length-j-1] * pow;
                    patternHash += s2[s2.length-j-1] * pow;

                    if (j < s2.length - 1) pow *= D;
                }
            }
            else parentHash = D * (parentHash - s1[i-1] * pow) + s1[s2.length-1+i];

            if (parentHash == patternHash) answer++;
        }

        return answer;
    }
}