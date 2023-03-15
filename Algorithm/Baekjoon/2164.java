// 2164 - 카드

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			queue.add(i+1);
		}
		System.out.println();
		
		while(queue.size() > 1) {
			queue.poll();
//			int second = queue.remove();
			queue.offer(queue.poll());	
		}
		
		System.out.println(queue.poll());

	}

}
