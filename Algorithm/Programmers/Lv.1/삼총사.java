class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length; i++){
            for(int j=i+1; j<number.length; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i] + number[j] + number[k] == 0){
                        answer++;
                    }
                }
            }
        }
        
        if(answer == 0) System.out.println("삼총사가 될 수 있는 방법이 없습니다.");
        
        return answer;
    }
}
