//11660 - 구간 합 구하기5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		int[][] dp = new int[N + 1][N + 1];

		for (int x = 1; x < N + 1; x++) {
			for (int y = 1; y < N + 1; y++) {
				dp[x][y] = dp[x][y - 1] + dp[x - 1][y] - dp[x - 1][y - 1] + arr[x][y];
			}

			System.out.println(Arrays.deepToString(dp));
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());

			int total = dp[x2][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];

			System.out.println(total);
		}

	}

}
