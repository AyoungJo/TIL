// 17608 - 막대기

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<n; i++) {
			stack.add(sc.nextInt());
		}

		int cnt = 1;

		int peek = stack.peek();

		for (int i = 0; i < stack.size(); i++) {			
			if (stack.get(i)> peek) {
				cnt++;
			} else {
				continue;
			}
		}
		System.out.println(cnt);

	}

}
