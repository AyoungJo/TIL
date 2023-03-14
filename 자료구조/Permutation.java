//순열
public class Permutation {

	static char[] arr = { 'A', 'B', 'C', 'D' };
	static int R; // 선택개수
	static int[] selection; // 현재 선택한 요소
	static boolean[] isSelected; // 마킹배열 - 선택했는지 체크

	// 중복 허용 O
	static void rep_permutation(int r) {

		if (r == R) {
			for (int i = 0; i < R; i++)
				System.out.print(arr[selection[i]]);
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			selection[r] = i;
			rep_permutation(r + 1);
		}
	}

	// 중복 허용 X
	static void permutation(int r) {

		if (r == R) {
			for (int i = 0; i < R; i++)
				System.out.print(arr[selection[i]]); // 결과 출력
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (isSelected[i])
				continue; // 중복인 경우 skip
			isSelected[i] = true; // 중복 마킹
			selection[r] = i; // 선택
			permutation(r + 1); // 다음 재귀로
			isSelected[i] = false; // 선택한걸 되돌려줘야 함
		}
	}

	public static void main(String[] args) {

		R = 2;
		selection = new int[R];
		isSelected = new boolean[arr.length];
		permutation(0);

	}

}
