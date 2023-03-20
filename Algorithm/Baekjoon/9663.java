// 9663 - NQueen

import java.util.Scanner;

public class B9663_NQueen_조아영 {

	static int N;
	static int[] chess;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		chess = new int[N];

		// 같은 행, 열, 대각선 모두 X
		Queen(0);
		System.out.println(cnt);

	}

	static void Queen(int q) {
		if (q == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			chess[q] = i;
			if (Check(q)) {
				Queen(q + 1);
			}
		}

	}

	static boolean Check(int check) {
		for (int i = 0; i < check; i++) {
			if (chess[check] == chess[i]) {
				return false;
			}
			if (Math.abs(check - i) == Math.abs(chess[check] - chess[i])) {
				return false;
			}
		}
		return true;
	}

}
