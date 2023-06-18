class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; //brown 수, yellow수
        int total = brown + yellow;
        
        for(int i=1; i<=total; i++){
            if(total % i == 0){ //i가 total의 약수일 때
                int width = i;
                int height = total / i;
                
                if(width >= height){
                  int count = (width-2)*(height-2);
                    if(count == yellow){
                        answer[0] = width;
                        answer[1] = height;
                        break;
                    }
                }
            }
            
        }
        
        return answer;
    }
}
