//11047 - 동전 0
//그리디 알고리즘

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 동전 종류
		int K = sc.nextInt(); // 동전 합

		int[] coin = new int[N];

		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		int cnt = 0;
		int result = 0;

		for (int i = coin.length - 1; i >= 0; i--) {
			if (coin[i] < K) {
				result = K / coin[i];
				cnt += result;
				K = K % (coin[i] * result);
			}
		}

		System.out.println(cnt);
	}

}
