
import java.util.Scanner;

public class B15650_N과M {
	
	static int[] arr;
	static int R; // 선택개수
	static int[] selection; // 현재 선택한 요소
	static boolean[] isSelected; // 마킹배열 - 선택했는지 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		R = M;
		selection = new int[M];
		isSelected = new boolean[arr.length];

		combination(0, 0);

	}

	static void combination(int r, int start) {
		if (r == R) {
			for (int i = 0; i < R; i++)
				System.out.print(arr[selection[i]] + " "); // 결과 출력
			System.out.println();
			return;
		}

		// 시작값을 넣어줘야 start값보다 작은 값은 안봄
		for (int i = start; i < arr.length; i++) {
			if (isSelected[i])
				continue; // 중복인 경우 skip
			isSelected[i] = true; // 중복 마킹
			selection[r] = i; // 선택
			combination(r + 1, i); // 다음 재귀로
			isSelected[i] = false; // 선택한걸 되돌려줘야 함
		}
	}
}
