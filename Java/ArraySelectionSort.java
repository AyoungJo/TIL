// 선택정렬 알고리즘을 이용하여 배열방에 있는 데이터를 오름차순으로 정렬하여 출력하기

public class ArraySelectionSort {

	public static void main(String[] args) {
		int arr[] = { 5, 7, 1, 2, 4, 3, 8, 9, 6, 10 };

		int len = arr.length;
		int temp = 0;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
