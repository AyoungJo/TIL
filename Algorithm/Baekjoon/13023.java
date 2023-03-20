// 13023 - ABCDE
// 백트래킹

import java.util.ArrayList;
import java.util.Scanner;

//dfs(노드, depth)
public class Main {

	static int N;
	static int M;
	static int cnt;
	static int flag = 0;
	static ArrayList<Integer>[] tree;
	static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		tree = new ArrayList[M + 1];

		for (int i = 0; i < M + 1; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}


		isVisited = new boolean[M + 1];
		cnt = 0;
		for (int i = 0; i < M + 1; i++) {
			if (isVisited[i] == false) {
				DFS(i, 1);
			}

		}
		System.out.println(flag);

	}

	static void DFS(int node, int cnt) {

		if (isVisited[node])
			return;

		if (cnt >= 5 || flag == 1) {
			flag = 1;
			return;
		}
		isVisited[node] = true;

		for (int nextNode : tree[node]) { 
			DFS(nextNode, cnt + 1);
		}
		isVisited[node] = false;

//		}
	}
}
