import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Solution2 {

	public boolean solution(int N, int[] A, int[] B) {
		int sequenceCount = 0;

		for (int i = 0; i < A.length; i++) {
			int departNode = Math.min(A[i], B[i]);
			int arrivalNode = Math.max(A[i], B[i]);
			if(isSequential(departNode, arrivalNode)) {
				sequenceCount++;
			}
		}
		return areAllNodesSequential(N, sequenceCount);
	}

	boolean areAllNodesSequential(int nodeCount, int sequenceCount) {
		return sequenceCount == nodeCount - 1;
	}

	boolean isSequential(int departNode, int arrivalNode) {
		return arrivalNode - departNode == 1;
	}

	@Test
	void test() {
		assertFalse(solution(2, new int[0], new int[0]));
	}
}
