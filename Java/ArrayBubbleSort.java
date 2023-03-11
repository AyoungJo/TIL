//버블정렬 알고리즘을 이용하여 배열방에 있는 데이터를 오름차순으로 정렬하여 출력하기

public class ArrayBubbleSort {

	public static void main(String[] args) {
		int arr[] = { 5, 7, 1, 2, 4, 3, 8, 9, 6, 10 };

		int len = arr.length;
		int temp = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
