//1931 - 회의실 배정
//그리디 알고리즘

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int start = 0;
		int cnt = 0;

		int[][] room = new int[N][2];

		for (int i = 0; i < N; i++) {
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(room, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) { // 종료시간이 같으면
					return o1[0] - o2[0]; // 시작시간이 빠른 대로 오름차순 정렬
				}
				return o1[1] - o2[1]; // 종료시간이 같지 않으면 종료시간이 빠른대로 오름차순 정렬
			}
		});

		for (int i = 0; i < N; i++) { // N=11
			if (start <= room[i][0]) { // 현재 시작시간
				start = room[i][1]; // 시작시간 = 직전 종료시간
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
