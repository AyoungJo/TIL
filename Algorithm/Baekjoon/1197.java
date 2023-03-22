// 1197 - 최소스패닝트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "[" + this.start + "," + this.end + "," + this.weight + "]";
	}

}

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {

//		Edge   

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int ans = 0;
		parent = new int[V + 1];
		Arrays.setAll(parent, i -> i);

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u, v, weight);
		}

//		System.out.println(Arrays.toString(edges));

		// 간선 정렬
		// edge 클래스에서 가중치로 정렬
		Arrays.sort(edges, (a, b) -> a.weight - b.weight); // 오름차순
//		Arrays.sort(edges, (a,b) -> -a.weight + b.weight);	//내림차순
//		System.out.println(Arrays.toString(edges));

		/// 구현
		for (int i = 0; i < E; i++) {
			if (find(edges[i].start) != find(edges[i].end)) {
				union(edges[i].start, edges[i].end);
				ans += edges[i].weight;
			}

		}

		System.out.println(ans);

	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
}
