//2750 - 수 정렬하기
//병합정렬 이용

public class B2750_병합정렬 {

	public static void mergeSort(int[] arr, int[] temp, int start, int end) {

		// 부분 집합 분할 결과 보기 : (start+end)/2
//		for (int i = start; i < end + 1; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();

		if (start >= end)
			return;
		int mid = (start + end) / 2;

		// 두개의 집합의 범위
		mergeSort(arr, temp, start, mid);
		mergeSort(arr, temp, mid + 1, end);

		// 병합 코드
		int left = start;
		int right = mid + 1;
		int idx = start;

		// 인덱스값 벗어났을 경우 에러 방지 위해 while문 사용
		// || 둘중 하나라도 벗어나지 않으면 배열을 채울 값이 남아있음
		while (left <= mid || right <= end) {
			if(left > mid) {
				temp[idx++] = arr[right++];
			}
			else if( right > end){
				temp[idx++] = arr[left++];
			}
			else if (arr[left] > arr[right]) {
					temp[idx++] = arr[right++];
			} else if(arr[right] > arr[left]) {
				temp[idx++] = arr[left++];				
			}
		}
		
		for(int i=start; i<end+1; i++) {
			arr[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 4, 1 };
		int[] temp = new int[arr.length]; // 정렬된 값 임시 저장

		mergeSort(arr, temp, 0, arr.length - 1);

	}

}
