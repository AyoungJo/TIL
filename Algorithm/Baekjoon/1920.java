// 1920 - 수찾기
// 이진탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int BinarySearch(int[] arr1, int target) {
		int mid = 0; // 중앙값
		int result = 0;

		for (int i = 0; i < arr1.length; i++) {
			int low = 0;
			int high = arr1.length - 1;

			while (low <= high) {
				mid = (low + high) / 2;

				if (arr1[mid] == target) {
					result = 1;
					return result;
				} else if (arr1[mid] > target) {
					high = mid - 1;
				} else if (arr1[mid] < target) {
					low = mid + 1;
				}
				result = -1;
			}
		}
		return result;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int target = 0;

		int N = Integer.parseInt(bf.readLine());
		int arr1[] = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int arr2[] = new int[M]; // 탐색값
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		int rs = 0;
		Arrays.sort(arr1);

		for (int i = 0; i < N; i++) {
			target = arr2[i];
			System.out.print(target + " : ");
			rs = BinarySearch(arr1, target);
			if (rs == 1) {
				System.out.println(1);

			} else {
				System.out.println(0);
			}
		}

	}

}
