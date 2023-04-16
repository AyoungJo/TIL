//11659 - 구간 합 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		int[] S = new int[N + 1];

		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = S[i - 1] + Integer.parseInt((st.nextToken()));
		}

		for (int x = 0; x < M; x++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			System.out.println(S[j] - S[i - 1]);
		}

	}

}

