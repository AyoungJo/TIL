// 2164 - 카드

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		System.out.println();
		
		while(queue.size() > 1) {
			queue.remove();
			int next = queue.remove();
			queue.add(next);	
		}
		
		System.out.println(queue.peek());

	}

}
