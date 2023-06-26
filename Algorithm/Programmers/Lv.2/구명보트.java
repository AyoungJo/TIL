import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        int boat = 0;
        int min = 0;
        int max = people.length-1;
        
        Arrays.sort(people);
        
        while(min <= max){
            
            if(people[min] + people[max] > limit){
                max--;
                boat++;
            } else {
                min++;
                max--;
                boat++;
            }            
        }              
        
        return boat;
    }
}
