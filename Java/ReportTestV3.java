// switch문
// 점수에 따라 A~F로 학점 변경 하기

public class ReportTestV3 {

	public static void main(String[] args) {
		String name = "조아영";

		int kor, eng, math, sum;
		double avg;
		char grade;

		kor = 97;
		eng = 63;
		math = 75;

		sum = kor + eng + math;
		avg = sum / 3.0;

		switch ((int) (avg / 10)) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
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
