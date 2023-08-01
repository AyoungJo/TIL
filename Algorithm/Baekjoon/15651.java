//N과 M(3) - 완전탐색

import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];

		// 1번째 요소부터 탐색
		Search(0);

		System.out.print(sb.toString());
	}

	static void Search(int i) {
		if (i == M) { // 모든 숫자를 다 탐색했을 경우
			for (int k = 0; k < M; k++) {
				sb.append(arr[k]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int n = 1; n <= N; n++) {
				arr[i] = n;
				Search(i + 1);
				arr[i] = 0;
			}
		}

	}

}
