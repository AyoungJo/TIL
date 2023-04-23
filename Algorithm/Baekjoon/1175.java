//1175 - 카드정렬하기
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//작은 값들을 누적시키기 위해 우선순위 큐 사용
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			que.add(num);
		}
		
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
		
		while(que.size()!=1) { //큐의 크기가 1보다 작으면 더이상 더할 값이 없음
			num1 = que.remove();
			num2 = que.remove();
			sum += num1+num2;
			que.add(num1+num2);
		}
		
		System.out.println(sum);
		
	}
}
