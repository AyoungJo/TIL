import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			
			if(a==0 && b==0) {
				break;
			}
			sb.append((a+b)).append('\n');
		}
		System.out.println(sb);

	}

}
