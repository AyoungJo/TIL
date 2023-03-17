import java.util.Stack;

//0 0 0 0 0
//0 0 1 0 3
//0 2 5 0 1
//4 2 4 4 2
//3 5 1 3 1
public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // !stack.isEmpty()

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		int result = 0;
		int d = 0;

		int B = board.length;
		int M = moves.length;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < B; j++) { // 0~4
				d = board[j][moves[i] - 1]; // ①주의
				if (d != 0) {
					if (stack.peek() == d) {
						stack.pop();
						result += 2;
					} else {
						stack.push(d);
					}
					// ① int 값에 배열 초기화 하면 아예 다른 값 들어감
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}

		System.out.println(result);

	}

}
