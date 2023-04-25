// 1920 - 수찾기
// 이진탐색

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int A[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 	// 숫자 개수
		A = new int[N]; 	// X라는 정수가 존재하는지 알아내야하는 숫자들
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		Arrays.sort(A); 	// 이진탐색을 위한 숫자 오름차순 정렬

		int X = sc.nextInt(); 	// 찾아야 하는 숫자 갯수

		for (int i = 0; i < X; i++) {
			int index = sc.nextInt();

			int result = bs(index);
			System.out.println(result);
		}

	}

	public static int bs(int index) {
		int start = 0;
		int end = A.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2; 	// 중앙값 구하기

			if (A[mid] > index) { 		// 중앙값>찾아야하는 숫자
				end = mid - 1; 		// 끝값을 중앙값보다 작게 초기화
			} else if (A[mid] < index) { 	// 중앙값<찾아야하는 숫자
				start = mid + 1; 	// 시작값을 중앙값보다 크게 초기화
			} else if (A[mid] == index) { 	// 숫자 존재
				return 1; 		// 1 반환
			}
		}
		return 0; // 존재하지 않음

	}

}
