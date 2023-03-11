//주제 : 삽입정렬 알고리즘을 이용하여 배열방에 있는 데이터를 오름차순으로 정렬하여 출력하기

public class ArrayInsertionSort {

	public static void main(String[] args) {
		int arr[] = { 5, 7, 1, 2, 4, 3, 8, 9, 6, 10 };

		int len = arr.length;

		for (int i = 1; i < len; i++) {

			int j = i;
			int temp = arr[i];

			while (((j > 0) && (arr[j - 1]) > temp)) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}

		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
