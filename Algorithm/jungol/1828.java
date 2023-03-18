// 1828 - 냉장고
//그리디 알고리즘

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] temp = new int[N][2];

		for (int i = 0; i < N; i++) {
			temp[i][0] = sc.nextInt(); // 최저 온도
			temp[i][1] = sc.nextInt(); // 최고 온도
		}

		// 최고 온도 오름차순 정렬
		Arrays.sort(temp, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});

		int max = temp[0][1];	//최고 기온
		int room = 1;			//냉장고(최소 한개는 필요함)
		for(int i=1; i<N; i++) {
			if(max<temp[i][0]) {	//이전 냉장고 최고 온도 < 다음 냉장고 최저 온도
				max = temp[i][1];
				room++;
			}
		}
		System.out.println(room);
	}

}
