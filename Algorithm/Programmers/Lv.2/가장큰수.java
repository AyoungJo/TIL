import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        //numbers 배열의 숫자를 비교해서 내림차순 정렬
        //오름차순 일 경우 (o1 + o2).compareTo(o2 + o1))
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        //가장 큰 수가 0일 경우, 0보다 큰 수는  없으므로 0 반환
        if(arr[0].equals("0")){
            return "0";
        }

        for(String number : arr){
            answer += number;
        }
        
        return answer;
    }
}
