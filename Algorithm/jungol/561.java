import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		int min = 0;
		int max = 10000;
		
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			arr[i] = num;					
		}
		
		for(int i=0; i<10; i++) {
			if(arr[i]<100 && min<arr[i]) {
				min = arr[i];
			}else if(arr[i]>=100 && max>arr[i]) {
				max = arr[i];
			}
		}
		
		if(min == 0) {
			min = 100;
		}
		if(max == 10000) {
			max = 100;
		}
		
		System.out.println(min + " " + max);

		sc.close();
	}

}
