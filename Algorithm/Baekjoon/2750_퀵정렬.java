//2750 - 수 정렬하기 
//퀵정렬 이용

import java.util.Scanner;

public class B2750_퀵정렬_solution {

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int partition(int[] arr, int start, int end) {

		int pivot = start;
		int left = start + 1;
		int right = end;

		while (left <= right) {// left와 right 엇갈릴 때

			// pivot보다 큰 값 찾기
			while (left <= right && arr[left] <= arr[pivot])
				left++;
			// pivot보다 작은 값 찾기
			while (left <= right && arr[right] >= arr[pivot])
				right--;

			// 엇갈린 경우
			if (left > right) {
				swap(arr, right, pivot);
			} else {
				swap(arr, left, right);
			}
		}

		return right;
	}

	public static void quicksort(int[] arr, int start, int end) {

		// 종료 조건
		if (start >= end) {
			return;
		}

		int pivot = partition(arr, start, end);

		quicksort(arr, start, pivot - 1); // pivot 기준 왼쪽 구간
		quicksort(arr, pivot + 1, end);

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
		quicksort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
