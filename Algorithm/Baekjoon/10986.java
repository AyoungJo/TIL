import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 수의 개수
		int m = Integer.parseInt(st.nextToken()); // 나누는 수

		long count = 0;
		long sum[] = new long[n + 1];
		long remain[] = new long[m];

		st = new StringTokenizer(br.readLine());
		
		//누적합
		for (int i = 1; i < n + 1; i++) {
			sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % m;			
			if (sum[i] == 0) {
				count++;
			}			
			//나머지가 같으면 +1
			remain[(int) sum[i]]++;
		}

		//나머지가 같은 n개 중에서 r개를 뽑는 모든 경우의 수
		for (int i = 0; i < m; i++) {
			if (remain[i] > 1) {
				count += (remain[i] * (remain[i] - 1) / 2);
			}
		}
		System.out.println(count);
	}

}
