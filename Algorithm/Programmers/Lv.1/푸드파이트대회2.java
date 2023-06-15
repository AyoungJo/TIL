class Solution {
    public String solution(int[] food) {
        String left = "";
        String right = "";
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                left += Integer.toString(i);
            }
        }
        
        StringBuffer sb = new StringBuffer(left);
        right = sb.reverse().toString();
        
        left += "0";
        
        return left+right;
    }
}
