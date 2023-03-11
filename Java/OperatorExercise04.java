//연산자
//값과 나머지 구하기

public class OperatorExercise04 {

	public static void main(String[] args) {
		int pencils = 534;
		int students = 30;

		// 학생 한 명이 가지는 연필 수
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);

		// 남은 연필 수
		int pencilsLeft = 534 % 30;
		System.out.println(pencilsLeft);

	}

}
