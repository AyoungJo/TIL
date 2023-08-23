import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //우선순위 큐 - 높은 값이 우선순위가 되도
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int process : priorities){
            pq.add(process);
        }
        
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                //i번째 배열과 가장 우선순위 값(pq.peek())과 같다면                
                if(priorities[i] == pq.peek()){ 
                    
                    //i와 찾고자 하는 프로세스의 인덱스가 같다면(동일한 프로세스)
                    if(i == location){  
                        return ++answer;
                    }
                    
                    //i와 찾고자 하는 프로세스의 인덱스가 같지 않다면(동일한 프로세스가 아님)
                    pq.poll();
                    answer++;
                }
            }
        }

        
        return answer;
    }
}
