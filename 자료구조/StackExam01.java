import java.util.Stack;

public class StackExam01 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.add(100);
		stack.add(200);
		stack.add(300);
		stack.add(400);
		stack.add(500);
		System.out.println(stack);

		int top = stack.pop();
		System.out.println("top : " + top + ", stack : " + stack);

		System.out.println(stack.peek());

		while (!stack.isEmpty()) {
//				stack.pop();
//				System.out.println(stack);
			System.out.println(stack.pop());
		}
		System.out.println(stack);
	}

}
