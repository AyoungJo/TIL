class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];        
        long next = 0;
        
        for(int i=0; i<n; i++){            
            next += x;
            answer[i] = next;
        }
        
        return answer;
    }
}
