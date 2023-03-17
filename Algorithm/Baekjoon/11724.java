// 11724 - 연결 요소의 개수
// 비연결 그래프, DFS 이용 풀이
// 1번의 탐색이 모든 집단을 탐색하는 것은 아니라는 것을 주의!

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int link;
	static ArrayList<Integer> tree[]; // 인접리스트
	static boolean isVisited[];
	
	//1개의 탐색이 1개의 집단

	static void DFS(int start) { // 1
		for (int nextNode : tree[start]) {
			if (!isVisited[nextNode]) {
				isVisited[nextNode] = true;
				DFS(nextNode); // 탐색
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		tree = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

		isVisited = new boolean[N + 1];
		isVisited[1] = true;

		for (int i = 1; i < N + 1; i++) {
			if (!isVisited[i]) {
				DFS(i);
				link++;
			}
		}
		System.out.println(link);

		// for (int i = 1; i < tree.length; i++) {
//			System.out.println(i + " 노드 : " + tree[i]);// 하나의 ArrayList
//		}

	}

}
