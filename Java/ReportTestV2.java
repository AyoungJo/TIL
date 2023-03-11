// if문
//점수에 따라 A~F로 학점 변경 하기

public class ReportTestV2 {

	public static void main(String[] args) {
		String name = "조아영";

		int kor, eng, math, sum;
		double avg;
		char grade;

		kor = 97;
		eng = 80;
		math = 75;

		sum = kor + eng + math;
		avg = sum / 3.0;

		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("이름 : " + name);
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("총점 : " + sum);
		avg = (int) (avg * 100) / 100.0;
		System.out.println("평균 : " + avg);
		System.out.println("학점 : " + grade);
	}

}
