// 1874 - 스택수열

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		StringBuilder builder = new StringBuilder(); 		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int idx = 1;
		
		for(int i=0; i<n; i++) {
			int now = arr[i];
			
			//스택이 비어있는 경우
			if(stack.isEmpty() || now >stack.peek()) {
				for(int j = idx; j<=now; j++) {
					stack.push(idx);
					idx++;
					builder.append("+\n");					
				}
				stack.pop();
				builder.append("-\n");
			}else if(now == stack.peek()){
				stack.pop();
				builder.append("-\n");

			}else if(now < stack.peek()) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println(builder.toString());
		
	}

}
