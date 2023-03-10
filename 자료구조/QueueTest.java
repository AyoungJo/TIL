import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<Integer> que_arr = new ArrayDeque<>();
//		Queue<Integer> que_list = new LinkedList<>();

		// 인큐 = 값추가 => add or offer
		que_arr.add(5);
		que_arr.add(2);
		que_arr.add(7);
		que_arr.offer(10);
		System.out.println(que_arr);

		// 디큐 = 값제거 => remove or poll
		que_arr.remove();
		que_arr.poll();
		System.out.println(que_arr);

		// peek()
		System.out.println(que_arr.peek());
		// isEmpty 메소드
		System.out.println(que_arr.isEmpty());

		// clear 메소드
		que_arr.clear();
		System.out.println(que_arr);
		System.out.println(que_arr.isEmpty());

	}

}
