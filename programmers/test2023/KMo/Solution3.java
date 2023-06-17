import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution3 {

	public int solution(int N, String S) {
		boolean[][] cantSitFamily = new boolean[N+1][3];
		if(S.isEmpty()) {
			return N * 2;
		}

		String[] reservations = S.split("\\s");
		for (String reservation : reservations) {
			int line = Integer.parseInt(reservation.substring(0, reservation.length() - 1));
			char seat = reservation.charAt(reservation.length() - 1);
			markReservedSeats(cantSitFamily, line, seat);
		}

		int answer = calculateFamilySeats(cantSitFamily);
		return answer;
	}

	private void markReservedSeats(boolean[][] cantSitTogether, int line, char seat) {
		switch (seat) {
			case 'B':
			case 'C':
				cantSitTogether[line][0] = true;
				break;
			case 'D':
			case 'E':
				cantSitTogether[line][0] = true;
				cantSitTogether[line][1] = true;
				break;
			case 'F':
			case 'G':
				cantSitTogether[line][1] = true;
				cantSitTogether[line][2] = true;
				break;
			case 'H':
			case 'J':
				cantSitTogether[line][2] = true;
				break;
		}
	}

	private int calculateFamilySeats(boolean[][] cantSitTogether) {
		int answer = 0;
		// 0번 라인은 PASS
		for (int i = 1; i < cantSitTogether.length; i++) {
			boolean[] perLine = cantSitTogether[i];

			if(!perLine[0] && !perLine[2]) {
				answer += 2;
				continue;
			}

			for (boolean perSet : perLine) {
				if(!perSet) {
					answer++;
					break;
				}
			}
		}
		return answer;
	}

	@Test
	void test() {
		assertEquals(41, solution(22, "1A 3C 2B 20G 5A"));
	}

}
