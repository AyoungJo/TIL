class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];        
        answer[0] = -1;
        
        for(int i=1; i<s.length(); i++){
            answer[i] = -1;     
          
            for(int j=i-1; j>=0; j--){
                if(s.charAt(j) == s.charAt(i)){
                    answer[i] = i-j;
                    break;
                }                
            }
        }
        
        return answer;
    }
}

/////////////////////////////////////////////////////////
/*class Solution {
    public int[] solution(String s) {
        
        String words[] = s.split("");
        int[] answer = new int[words.length];
        
        answer[0] = -1;
        
        for(int i=1; i<words.length; i++){
            answer[i] = -1;
            
            for(int j=i-1; j>=0; j--){
                if(words[j].equals(words[i])){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        
        return answer;
    }
}*/
