//제어문
//키보드로 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하기

import java.util.Scanner;

public class WhileExercise07 {

	public static void main(String[] args) {
		boolean run = true;

		int balance = 0;

		Scanner scanner = new Scanner(System.in);

		while (run) {

			System.out.println("----------------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------------------");
			System.out.println("선택> ");

			int num = scanner.nextInt();

			if (num == 1) {
				System.out.println("예금액> ");
				balance += scanner.nextInt();
			} else if (num == 2) {
				System.out.println("출금액> ");
				balance -= scanner.nextInt();
			} else if (num == 3) {
				System.out.println("잔고> " + balance);
			} else if (num == 4) {
				run = false;
				break;
			}

		}

		System.out.println("프로그램 종료");

	}

}
