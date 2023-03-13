//2750 - 수 정렬하기 
//선택정렬 이용

import java.util.Scanner;

public class B2750_선택정렬 {

	public static void selectionsort(int[] arr, int N) {

		for (int i = 0; i < N - 1; i++) { // i=0
			int min = i;

			for (int j = i; j < N; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
				if (arr[i] > arr[min]) {
					int temp = arr[min];
					arr[min] = arr[i];
					arr[i] = temp;

				}
			}
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
		selectionsort(arr, N);

	}

}
