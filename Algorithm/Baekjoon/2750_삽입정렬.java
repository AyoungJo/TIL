//2750 - 수 정렬하기 
//삽입정렬 이용

import java.util.Scanner;

public class B2750_삽입정렬 {

	public static void Insertionsort(int[] arr, int N) {

		int min = 0;
		int j = 0;
		// 5 2 3 4 1
		for (int i = 1; i < N; i++) {
			min = arr[i];

			for (j = i - 1; j >= 0 && min < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = min;
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void main(String[] args) {

		// 입력 처리
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 정렬
		Insertionsort(arr, N);
	}

}
