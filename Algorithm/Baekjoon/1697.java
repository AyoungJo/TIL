// 1697 - 숨바꼭질

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int cnt;
	static int result;
	static int[] find;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); 
		M = sc.nextInt(); 

		cnt = 0; // 찾는 시간
		result = 0;

		find = new int[100001];

		result = BFS(N);
		System.out.println(result);
	}

	static int BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int index = node;
		queue.add(index);
		find[index] = 1;
		int n =0;
		
		while(!queue.isEmpty()) {
			n = queue.poll();
			if (n == M) {
				return find[n] - 1;
			}
			if((n-1)>=0 && find[n-1] ==0) {
				find[n-1] = find[n] + 1;
				queue.add(n-1);
			}
			if((n+1)<=M && find[n+1] == 0) {
				find[n+1] = find[n] + 1;
				queue.add(n+1);
			}
			if((n*2)<=M && find[n*2] == 0) {
				find[n*2] = find[n] + 1;
				queue.add(n*2);
			}
			
		}
		return -1;

	}

}
