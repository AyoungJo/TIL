//4가지 모양ㅇ으로 별찍기

public class StarExam {

	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("**************");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= 6 - i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("**************");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6 - i; j++) {
				System.out.print("　");
			}
			for (int x = 1; x < i + 1; x++) {
				System.out.print("★");
			}
			System.out.println();
		}

		System.out.println("**************");

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("　");
			}
			for (int x = 5; x >= i; x--) {
				System.out.print("★");
			}
			System.out.println();
		}

		// 마지막 별 추가 코드
		System.out.println();
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("　");
			}
			for (int x = i; x <= 5; x++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}

}
