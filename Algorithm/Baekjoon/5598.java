//5598 - 카이사르 암호

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        String before = sc.nextLine();
        char[] after = before.toCharArray();

        for (int i = 0; i < before.length(); i++) {
            char word = (char) (before.charAt(i) - 3);
            if (word < 'A') {
            	after[i] = (char) (word + 20);
            } else {
            	after[i] = (char) (word);
            }
        }
        
        System.out.print(after);
        
        sc.close();
    }
}
