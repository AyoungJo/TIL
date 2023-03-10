import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
        int[] arr = new int[26];
	    for (int i = 0; i < 26; i++) {
	    	arr[i] = 0;
	    }
		
	    //입력되는 문자의 개수는 2개 이상 100개 이하
        for (int i=0; i<100; i++) {
        	//입력되는 문자 중 첫번째 문자 가져오기
        	char ch = sc.next().charAt(0);  
        	//영문 대문자 이외의 문자가 입력되면 입력 중단
        	if (ch < 'A' || ch > 'Z') {
        		break;
        	}        	
        	arr[ch-'A']++;
        }		
        
        for(int i=0; i<26; i++) {
        	//입력된 문자만 출력하기
        	if(arr[i]!=0) {
        		System.out.print((char)(int)(i+65) + " : ");
        		System.out.println(arr[i]);
        	}
        }
        
        sc.close();
	}

}
