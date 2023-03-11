// 이중 do-while문
// 1부터 100까지 10행 10열로 출력하기
public class DoWhileExam {

	public static void main(String[] args) {
		int x = 1;

		int i = 1;
		do {
			int j = 1;
			do {
				System.out.print(x + " ");
				x++;
				j++;
			} while (j <= 10);
			System.out.println();
			i++;
		} while (i <= 10);

		// 변수i,j로 해결하기
		System.out.println();
		System.out.println("==========추가코드===========");

		int a = 0;
		do {
			int b = 1;
			do {
				System.out.print((a + b) + " ");
				b++;
			} while (b <= 10);
			System.out.println();
			a += 10;
		} while (a < 100);

	}

}
