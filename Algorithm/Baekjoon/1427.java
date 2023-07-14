//1427 - 소트인사이드

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String num = sc.next();

		int[] arr = new int[num.length()];

		for (int i = 0; i < num.length(); i++) {
			arr[i] = Integer.parseInt(num.substring(i, i + 1));
		}

		for (int i = 0; i < num.length(); i++) {
			int max = i;

			for (int j = i + 1; j < num.length(); j++) {
				if (arr[j] > arr[max]) {
					max = j;
				}
			}

			if (arr[i] < arr[max]) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

}
