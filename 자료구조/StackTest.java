import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		System.out.println(stack); // toString()

		// push 메소드
		stack.push(1);
		stack.push(7);
		stack.push(3);
		stack.push(2);
		stack.push(4);
		stack.push(6);
		System.out.println(stack);

		// pop 메소드 : 가장 끝에 있는 값 제거
		int pop_value = stack.pop();
		System.out.println("제거한 값 : " + pop_value);
		System.out.println(stack);

		// peek 메소드 : 가장 위(끝)에 있는 값 확인
		System.out.println(stack.peek());

		// isEmpty 메소드 : 스택 비어있는 여부 확인
		System.out.println(stack.isEmpty());

		// clear 메소드 : 스택 비워주는 메소드
		stack.clear();
		System.out.println("clear() 후 : " + stack.isEmpty());

		stack.add(10);
		stack.remove(2); // 가장 끝 인덱스 빼줘야 시간복잡도 O(1)

	}

}
