//4방탐색

public class Delta04 {

	public static void main(String[] args) {

		int N = 4;
		int delta[][] = { { 1, 2, 3, 4 }, 
							{ 5, -1, 7, 8 }, 
							{ 9, 10, 11, 12 }, 
							{ 13, 14, -1, 16 } };
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { -1, 1, 0, 0 };


		// 4방탐색
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (delta[y][x] == -1) { //-1의 4방 탐색(상, 하, 좌 우)
					for(int d=0; d<N; d++) {
						int now_y = y + dy[d];
						int now_x = x + dx[d];
						
						//범위를 벗어나는 값 예외처리
						if(now_y<0 || now_x<0 || now_y>=N || now_x>=N) continue;
						
						System.out.print(delta[now_y][now_x] + " ");
					}
					System.out.println();
				}
			}
		}

	}

}
