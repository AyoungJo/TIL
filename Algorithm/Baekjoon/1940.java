//1940 - 주몽
//투포인터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()); // 재료의 개수
		int M = Integer.parseInt(bf.readLine()); // 갑옷을 만드는데 필요한 수

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int c[] = new int[N]; // 갑옷 재료 고유 번호 clothes

		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(c);

		int cnt = 0; // 만들어지는 갑옷 수
		int start = 0;
		int end = N - 1;

		while (start < end) {
			if (c[start] + c[end] > M) {
				end--;
			} else if (c[start] + c[end] < M) {
				start++;
			} else { // (c[start]+c[end] == M)
				cnt++;
				start++;
				end--;
			}
		}

		System.out.println(cnt);

	}

}
