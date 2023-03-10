package day02work;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = new String[10];
		String alpahbet = sc.nextLine();
		arr = alpahbet.split(" ");
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}

		sc.close();
	}

}
