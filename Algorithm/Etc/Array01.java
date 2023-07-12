import java.util.Arrays;
import java.util.Scanner;

public class p68_q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();
		int a[] = new int[len];
		int b[] = new int[len];

		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println("Q2.역순정렬 ==============");
		reverse(a);
		
		System.out.println("Q3.요소의 합계 ==============");
		sumOf(a);
		
		System.out.println("Q4.배열 복사 ==============");
		copy(a,b);
	}
	
	static void copy(int[] a, int[] b) {
		for(int i=0; i<a.length; i++) {
			b[i] = a[i];
		}
		System.out.println("b copy = " + Arrays.toString(b));
	}

	 static void sumOf(int[] a) {
		 int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		System.out.println("sum = " + sum);
		
	}

	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			System.out.println(Arrays.toString(a));
			System.out.println("a[" + i + "]와 a[" + (a.length - i - 1) + "]을 교환합니다.");
			
			swap(a, i, a.length - i - 1);
		}
		System.out.println("역순 정렬을 마쳤습니다.");
	}

	static void swap(int[] a, int idx1, int idx2) {
		int r = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = r;
	}
}
