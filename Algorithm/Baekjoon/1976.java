// 1976 - 여행가자
// 유니온 

import java.util.Scanner;

public class B1976_여행가자_조아영 {

	static int n, m;
	static int parent[];
	static int uf[][];
	static int start[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 3
		m = sc.nextInt(); // 3

		parent = new int[n + 1];
		uf = new int[m + 1][m + 1];
		start = new int[m + 1];

		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;

		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (sc.nextInt() == 1) {
					union(i, j);
				}

			}
		}
		for (int a = 1; a < m + 1; a++) {
			start[a] = sc.nextInt();
		} // 1 2 3

		for (int a = 1; a < m + 1; a++) {
			if (find(start[a]) != find(start[1])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

//////////////////////////////////////////////
	// x의 부모를 찾는 연산
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	// y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
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
