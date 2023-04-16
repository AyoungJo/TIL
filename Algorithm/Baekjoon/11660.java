//11660 - 구간 합 구하기 5

package april04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2차원 구간 합 배열
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

		int[][] A = new int[N + 1][N + 1]; // 숫자 배열 생성

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int D[][] = new int[N + 1][N + 1]; // 구간합 배열 생성

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
			}
		}

		// 총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
			System.out.println(result);
		}

	}

}
