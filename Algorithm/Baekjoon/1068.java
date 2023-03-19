//1068 - 트리

import java.util.ArrayList;
import java.util.Scanner;

public class B1068_트리_조아영 {
	static int N; // 노드 개수
	static int D; // 삭제할 노드 번호
	static int rootNode;
	static int cnt;
	static ArrayList<Integer> tree[];
//	static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		tree = new ArrayList[N];

		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			int value = sc.nextInt();
			if (value == -1) {
				rootNode = i;
			} else {
				tree[value].add(i);
			}
		}

		D = sc.nextInt(); // 지울 노드
		// 지울노드 삭제
		for (int i = 0; i < N; i++) {
			tree[i].remove(Integer.valueOf(D));
		}

		dfs(rootNode);
		System.out.println(cnt);
	}

	static void dfs(int node) {
		if (node == D) {
			return;
		}
		if (tree[node].size() == 0) {
			cnt++;
		}
		for (int nextNode : tree[node]) {
			dfs(nextNode);

		}

	}

}
