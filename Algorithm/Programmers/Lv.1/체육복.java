import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
      
        int answer = answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);     
        
        //여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        //여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]-1 == reserve[j] 
                   || lost[i]+1 == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
