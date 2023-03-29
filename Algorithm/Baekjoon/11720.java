//11720 - 숫자의 합 구하기
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String arr1 = sc.next();

		char[] arr2 = new char[N];
		arr2 = arr1.toCharArray();

		int sum = 0;
		for (int i = 0; i < arr2.length; i++) {
			sum += arr2[i] - '0'; // 문자열 정수로 변환
		}

		System.out.println(sum);

	}

}
