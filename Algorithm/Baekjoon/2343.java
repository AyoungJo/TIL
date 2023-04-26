//2343 - 기타레슨
//이진 탐색
//23/04/26 - 1차 시도 (실페)

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
			int cnt = 0; //블루레이 최대 3개
			
			for(int i=0; i<N; i++) {				
				sum += L[i];
				
				if(sum>mid) { //
					cnt++;
					sum = 0; //합이 블루레이보다 크면 합을 멈추고 다음 레슨 값부터 다시 더해주기 위해 0으로 초기화
				}				
			}		
			if(cnt>M) {
				//1. 중앙값 크기의 블루레이에 모든 레슨을 담을 수 있으면 끝 인덱스 = 중앙값-1
				end = mid - 1;
				
			}else {
				//2. 중앙값 크기의 블루레이에 모든 레슨을 담을 수 없으면 시작 인덱스 = 중앙값+1
				start = mid + 1;
			}
		}
		
		System.out.println(start);
		
		/*
		 * for(int i=0; i<N; i++) { System.out.print(L[i] + " "); }
		 * System.out.println("start = " + start + ", end = " + end);
		 */
		
	}

}
