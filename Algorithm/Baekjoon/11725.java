//11725 - 트리의 부모 찾기

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int N;
	static ArrayList<Integer> tree[]; // 인접리스트
	static boolean isVisited[];
	static int parent[];

	public static void Search(int node) {

		// tree[node] 안에 들어있는 값 찾기
		for (int nextNode : tree[node]) { // nextNode : 자식 노드
			if (isVisited[nextNode])
				continue;
			isVisited[nextNode] = true;
			Search(nextNode);
			parent[nextNode] = node; // parent[자식] : 부모노드

		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		tree = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);

		}
//		for (int i = 0; i < tree.length; i++) {
//			System.out.println(i + " 노드 : " + tree[i]);// 하나의 ArrayList
//		}

		parent = new int[N + 1];
		// RootNode 부터 탐색

		// 중복 노드 들어가지 않도록
		isVisited[1] = true;

		Search(1); // [6,4] Search(6); Search(4);

//		System.out.println(tree[1]);

		for (int i = 2; i < N + 1; i++) {
			System.out.println(parent[i]);
		}
	}

}
