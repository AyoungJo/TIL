//2343 - 기타레슨
//이분 탐색
//23/04/26 - 1차 시도 (실패)
//23/04/27 - 2차 시도 (성공)

import java.util.Scanner;

public class Main {

	// 모든 강의를 M개의 동일한 크기를 가진 블루레이에 담을 때 블루레이 최소 크기
	//1. 시작인덱스 = 가장 긴 레슨 수
	//2. 끝 인덱스 = 모든 레슨이 걸리는 시간의 합
	//3. (시작+끝)/2 = 중앙값
	//4. 중앙값에 모든 레슨들을 블루레이 3개로 나눠 담을 수 있을때 까지 +1 . 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //레슨 수
		int M = sc.nextInt(); //블루레이 개수 - 최소 크기 구하기
		
		int[] L = new int[N];
		
		int start = 0; //시작 인덱스 = 가장긴 레슨
		int end = 0; //끝 인덱스 = 모든 레슨 시간의 합
		
		
		for(int i=0; i<N; i++) {
			L[i] = sc.nextInt();
			if(start<L[i]) {	//가장 긴 레슨 구하기
				start = L[i];
			}
			end += L[i];	//모든 레슨의 합
		}
				
		while(start<=end) {	//시작 인덱스 > 끝 인덱스 --> 탐색 종료
			int mid = (start+end)/2;
			int sum = 0;//하나의 블루레이에 담을 수 있는 레슨의 합
			int cnt = 1; //블루레이 최대 3개 -> cnt == 1 부터 시작 
			
			for(int i=0; i<N; i++) {				
				
				if(sum + L[i]>mid) { 
					cnt++;			//합이 블루레이 크기보다 크면 새로운 블루레이에 담아줌
					sum = L[i];		//새로운 블루레이에 그 다음 레슨 담아주기
				}else {
					sum += L[i];	//합이 블루레이 크기보다 작으면 같은 블루레이에 계속 해서 레슨 담기
				}
			}		

			if(cnt>M) {	//레슨이 담긴 블루레이 개수 > 고정 블루레이 개수(3개) 
				//시작 인덱스 = 중앙값 + 1
				start = mid + 1;
				
			}else { //레슨이 담긴 블루레이 개수 <= 고정 블루레이 개수(3개) 
				//끝 인덱스 = 중앙값 + 1
				end = mid - 1;
			}
		}
		
		System.out.println(start);

	}
}
