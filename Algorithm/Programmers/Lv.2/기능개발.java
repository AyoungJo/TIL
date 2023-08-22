import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        
        //배포 가능까지 필요한 작업 기간
        int[] days = new int[progresses.length];
        
        //배포 기간 저장
        for(int i=0; i<progresses.length; i++){           
           if(((100-progresses[i]) % speeds[i]) == 0){
                days[i] = (100-progresses[i]) / speeds[i];
                que.add(days[i]);
           }else{
                days[i] = (100-progresses[i]) / speeds[i];
                que.add(days[i]+1);               
           }
        }
        
        // 결과값 저장
        List<Integer> resultList = new ArrayList<>(); 
        
        int result = 1;     //첫번째 작업은 가장 먼저 배포가 됨
        
        while(!que.isEmpty()){
            int x = que.poll(); //첫번째 작업 소요 기간
            
            while(!que.isEmpty() && x >= que.peek()){ //다음 작업이 존재하고 함께 배포가 가능할 경우
                result++;
                que.poll(); //같이 배포 해서 삭제
            }
            
            resultList.add(result); //결과값 저장
            result = 1; //다음 배포를 위해 다시 1로 초기화
            
        }        
        
        int[] answer = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
