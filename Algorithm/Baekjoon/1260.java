//1260 - DFS와 BFS
//230412

package a0410;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
	static int N;
	static int M;
	static int V;

	static ArrayList<Integer>[] tree;
	static boolean[] isVisited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			tree[u].add(v);
			tree[v].add(u);
		}

		/*
		 * for(int i=1; i<M; i++) { System.out.println(i+"노드" + tree[i]); }
		 */
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(tree[i]);
		}

		isVisited = new boolean[N + 1];
		dfs(V);

		System.out.println();

		isVisited = new boolean[N + 1];
		bfs(V);

	}

	public static void dfs(int node) {
		System.out.print(node + " ");
		isVisited[node] = true;
		for (int nextNode : tree[node]) {
			if (!isVisited[nextNode]) {
				dfs(nextNode);
			}
		}
	}

	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(node);
		isVisited[node] = true;

		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");
			for (int nextNode : tree[nowNode]) {
				if (!isVisited[nextNode]) {
					isVisited[nextNode] = true;
					queue.add(nextNode);
				}
			}
		}

	}

}
