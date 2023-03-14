//부분집합

public class Subset {
	static char[] arr;
	static int N;
	static int cnt = 0;

	static boolean[] isSelected;

	static void subset(int num) {

		// 종료조건
		if (num == N) {
			cnt++;
			for (int i = 0; i < N; i++)
				if (isSelected[i])
					System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}

		// 분할

		// 선택O
		isSelected[num] = false;
		subset(num + 1);

		// 선택X
		isSelected[num] = true;
		subset(num + 1);

	}

	public static void main(String[] args) {

		arr = new char[] { 'A', 'B', 'C', 'D' };
		N = arr.length;

		isSelected = new boolean[N];

		subset(0);

		System.out.println("부분집합의 총 개수 : " + cnt);

	}
}
