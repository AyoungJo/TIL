//11659 - 구간 합 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());

		int[] arr = new int[N + 1]; // 수의 개수 배열공간

		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt((token.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());

			System.out.println(arr[v] - arr[k - 1]);
		}

	}

}
