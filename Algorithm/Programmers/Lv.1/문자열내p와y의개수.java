class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int countP = 0;
        int countY = 0;

        s = s.toUpperCase();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                countP++;
            } else if (s.charAt(i) == 'Y') {
                countY++;
            }
        }       
        
        if (countP == countY) {
            answer = true;
        } else if (countP != countY) {
            answer = false;
        }

        return answer;
    }
}
