class Solution {
    public String solution(int[] food) {
        String left = "";
        String right = "";
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                left += Integer.toString(i);
            }
        }
        
        for(int i = left.length()-1; i>=0; i--){
            right += left.charAt(i);
        }
        
        left += "0";
        
        return left+right;
    }
}
