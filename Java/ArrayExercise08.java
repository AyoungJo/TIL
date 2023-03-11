//배열, 중첩 for문
//배열의 전체 합과 평균 구하기

public class ArrayExercise08 {

	public static void main(String[] args) {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		int sum = 0;
		double avg = 0.0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
				avg += 1;
			}
		}
		avg = sum / avg;

		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

	}

}
