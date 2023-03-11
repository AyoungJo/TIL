// 1부터 100까지 10행 10열로 출력하기 

public class ForExam {

	public static void main(String[] args) {
		int x = 1;
		
		for(int i=1;i<=10;i++) { 					
			for(int j=1;j<=10;j++) {
				System.out.print(x+" ");
				x++;				
			}			
			System.out.println();			
		 }
	}

}
