//풀이 방법 1.
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        //최종 지갑의 가로, 세로 크기
        int maxWidth = 0;
        int maxHeight = 0;    
        
        for(int i=0; i<sizes.length; i++){
            int width =  sizes[i][0];
            int height = sizes[i][1];
            
            if(width > height){
                int temp = width;
                width = height;
                height = temp;
            }
            
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxWidth * maxHeight;
    }
}

//풀이 방법 2.
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int width = 0;
        int height = 0;
        
        //최종 지갑의 가로, 세로 크기
        int maxWidth = 0;
        int maxHeight = 0;   
                
        for(int i=0; i<sizes.length; i++){            
            for(int[] size : sizes){
                width = Math.max(size[0], size[1]);
                height = Math.min(size[0], size[1]);
                
                maxWidth = Math.max(maxWidth, width);
                maxHeight = Math.max(maxHeight, height);
            }                        
        }
        
        return maxWidth * maxHeight;
    }
}
