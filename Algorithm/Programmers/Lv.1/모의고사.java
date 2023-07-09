import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int first[] = {1,2,3,4,5}; //1번 수포자
        int second[] = {2,1,2,3,2,4,2,5};   //2번 수포자
        int third[] = {3,3,1,1,2,2,4,4,5,5}; //3번 수포자
        
        int score[] = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i%5]){
                score[0]++;
            }
            if(answers[i] == second[i%8]){
                score[1]++;
            } 
            if(answers[i] == third[i%10]){
                score[2]++;
            }             
        }
        
        //최고 점수
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        //가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬      
        ArrayList<Integer> list = new ArrayList<>();
        if(max == score[0]){
            list.add(1);
        } 
        if(max == score[1]){
            list.add(2);
        } 
        if(max == score[2]){
            list.add(3);
        } 
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
