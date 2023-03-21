// 1717 - 집합의 표현
// 유니온 파인드

import java.util.Scanner;

//1로 시작하는 입력에 대해서 a와 b가 같은 집합에 포함되어 있으면 
//"YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
public class Main {

	static int n, m;
	static int parent[];
	static int uf[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 7
		m = sc.nextInt(); // 8

		parent = new int[n + 1];
		uf = new int[m + 1];

		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			uf[i] = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (uf[i] == 0) {
				union(x, y);
			} else if (uf[i] == 1) {
//				find(x);
				if (find(x) == find(y)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}

	}

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
