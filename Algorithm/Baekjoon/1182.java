// 1182 - 부분수열의 합

import java.util.Scanner;

public class Main {
	static int N; // 정수의 개수
	static int S; // 합 결과
	static int[] arr;

	static int sum; // 결과 값 담을 변수
	static int flag;
	static int cnt = 0;

	static boolean[] isSelected;

	static void sum(int num) {

		if (num == N) {
			sum = 0;
//			flag = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
//					flag = 1;
					sum += arr[i];
				}
			}

			if (sum == S) {
				cnt++;
			}
			return;
		}

		isSelected[num] = true;
		sum(num + 1);

		isSelected[num] = false;
		sum(num + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		N = arr.length;
		isSelected = new boolean[N];

		sum(0);

		if (S == 0) {
			cnt -= 1;
		}
		System.out.println(cnt);
	}

}
