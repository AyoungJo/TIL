// 이중 for문
// 1부터 100까지 10행 10열로 출력하기
public class WhileExam {

	public static void main(String[] args) {
		int x = 1;

		int i = 1;
		while (i <= 10) {
			int j = 1;
			while (j <= 10) {
				System.out.print(x + " ");
				x++;
				j++;
			}
			System.out.println();
			i++;
		}

		// 변수i,j로 해결하기
		System.out.println();
		System.out.println("==========추가코드===========");

		int a = 0;
		while (a < 100) {
			int b = 1;
			while (b <= 10) {
				System.out.print((a + b) + " ");
				b++;
			}
			System.out.println();
			a += 10;
		}
	}

}
