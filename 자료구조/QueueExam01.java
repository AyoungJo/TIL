package day02;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExam01 {

	public static void main(String[] args) {

		Queue<Integer> queue = new ArrayDeque<>();
//		Queue<Integer> queue = new LinkedList<>();

		queue.offer(100); // add()
		queue.offer(200);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		System.out.println(queue);

		int front = queue.remove();// poll()
		System.out.println("remove : " + front + ", queue : " + queue);

		System.out.println(queue.peek());

		while (!queue.isEmpty()) {
			queue.remove();
			System.out.println(queue);
		}

	}
}
