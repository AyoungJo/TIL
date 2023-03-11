//배열
//학생 수와 각 학생들의 점수를 입력 받아 최소 점수 및 평균 점수를 구하기 

import java.util.Scanner;

public class ArrayExercise09 {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.println("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				System.out.println("학생수> ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: ");
					scores[i] = scanner.nextInt();
				}

			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				double sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (max < scores[i]) {
						max = scores[i];
					}
				}
				;
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + sum / scores.length);

			} else if (selectNo == 5) {
				System.out.println("프로그램 종료");
				run = false;
			}

		}

	}

}
