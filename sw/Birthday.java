import java.util.*;
import java.io.*;

class Birthday
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String args[]) throws Exception
    {
        int T;
        T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int big = Math.max(x, y);
            int small = Math.min(x, y);

            if(big == 0) {
                System.out.printf("#%d %s\n", test_case, "-1");
                continue;
            }

            if(N.length() == 1 && Integer.parseInt(N) < small) {
                System.out.printf("#%d %s\n", test_case, "-1");
                continue;
            }

            StringBuilder sb = new StringBuilder();

            boolean diffFlag = false;
            boolean notFirstZero = false;

            while (true) {
                char c = N.charAt(sb.length());
                int n = Character.getNumericValue(c);

                // TODO n이 small과 같고 뒤에 것이 더 크면 big을 넣는 것이 나음
                int target = -1;

                if(diffFlag) {
                    target = big;
                } else {
                    if(n < big && n >= small) {
                        target = small;
                    }

                    if(n >= big) {
                        target = big;
                    }

                    if(n < small) {
                        target = big;
                    }

                    if(target == 0 && !notFirstZero) {
                        target = big;
                    }

                    if(target != n) {
                        if(n < small) {
                            int tmp = 0;
                            for(int i = sb.length()-1; i >= 0; i--) {
                                int numericValue = Character.getNumericValue(sb.charAt(i));
                                if(numericValue > small) {
                                    tmp = i;
                                    break;
                                }
                            }
                            if(sb.length() > 0 && Character.getNumericValue(sb.charAt(tmp)) > small) {
                                sb.delete(tmp, sb.length());
                                sb.append(small);
                            } else {
                                sb = new StringBuilder();
                            }
                        }
                        diffFlag = true;
                    }
                }

                sb.append(target);

                if(sb.length() == N.length()) {
                    String answer = sb.toString();
                    if(isSmaller(answer, N)) {
                        System.out.printf("#%d %s\n", test_case, answer);
                        break;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    answer = sb.toString();
                    if(answer.isEmpty()) answer = "-1";
                    System.out.printf("#%d %s\n", test_case, answer);
                    break;
                }

                notFirstZero = true;

            }

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }

    static boolean isSmaller(String origin, String target) {
        if(origin.length() < target.length()) {
            return true;
        }
        for (int i = 0; i < origin.length(); i++) {
            if(origin.charAt(i) < target.charAt(i)) {
                return true;
            }
            if(origin.charAt(i) > target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}