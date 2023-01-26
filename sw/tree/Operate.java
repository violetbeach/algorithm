package tree;/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

/*
   성공은 했지만, 더 좋은 점화식이 있었다.

   리프노드가 아니면서 값이 숫자거나, 리프노드이면서 연산자일 경우에만 탈출(0 리턴)을 해주면 되었다.
 */
class Operate
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();

            Node[] nodes = new Node[N+1];
            for(int i = 1; i <= N; i++) {
                nodes[i] = new Node();
            }

            sc.nextLine();

            for(int i = 1; i <= N; i++) {
                String[] str = sc.nextLine().split(" ");

                Node node = nodes[Integer.parseInt(str[0])];
                node.isNumber = Character.isDigit(str[1].charAt(0));

                if(str.length >= 3) {
                    node.left = nodes[Integer.parseInt(str[2])];
                }

                if(str.length >= 4) {
                    node.right = nodes[Integer.parseInt(str[3])];
                }

            }

            Node head = nodes[1];

            if(isNumber(head)) {
                System.out.printf("#%d %d\n", test_case, 1);
            } else {
                System.out.printf("#%d %d\n", test_case, 0);
            }

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }

    public static boolean isNumber(Node node) {
        if(node.left != null && node.right != null) {
            if(isNumber(node.left) && isNumber(node.right) && !node.isNumber) {
                return true;
            } else {
                return false;
            }

        } else if(node.left == null && node.right == null) {
            if(!node.isNumber) {
                return false;
            }
        }
        return true;
    }

    static class Node {
        boolean isNumber;
        Node left;
        Node right;
    }
}