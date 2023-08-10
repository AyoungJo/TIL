class Solution {
    public int[] solution(long n) {

        String str = String.valueOf(n);
        int len = str.length();
        
        int[] answer = new int[len];
        
        int idx = 0;
        
        while(n != 0){
            long remain = n % 10 ;
            n /= 10;            
            answer[idx++] = (int) remain;
        }
        
        return answer;
    }
}
