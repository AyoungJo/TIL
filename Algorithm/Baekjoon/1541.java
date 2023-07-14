import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String num = sc.nextLine();
		String[] arr = num.split("-");

		int result = 0;
        
		/*
		 * for(int i=0; i<arr.length; i++) { 
             System.out.println("arr[" + i + "] = " + arr[i]); 
           }
		 */

		for (int i = 0; i < arr.length; i++) {
			int temp = operator(arr[i]);

			if (i == 0) {
				result += temp;
			} else {
				result -= temp;
			}
		}

		System.out.println(result);
	}

	private static int operator(String number) {
		int sum = 0;
		String temp[] = number.split("\\+");

		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
