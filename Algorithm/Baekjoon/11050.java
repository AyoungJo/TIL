//11050 - 이항계수1 : 조합 문제
//230413

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 숫자 총 개수
		int K = sc.nextInt(); // 선택 개수

		// 점화식을 위한 DP배열 선언
		int[][] dp = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			dp[i][1] = i; // i개 중에서 1개를 선택할 경우의 수
			dp[i][0] = 1; // i개 중에서 0개를 선택할 경우의 수
			dp[i][i] = 1; // i개 중에서 i개를 선택할 경우의 수
		}

		// 선택 개수가 총 개수보다 크면 안됨
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				// 위의 두개의 값들을 더한 값이 해당 값이 됨
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}

		// 5개의 숫자에서 2개를 선택할 경우의 수 출력
		System.out.println(dp[N][K]);

	}
}
