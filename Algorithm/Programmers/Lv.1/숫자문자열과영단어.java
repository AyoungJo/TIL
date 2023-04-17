class Solution {
    public int solution(String s) {
        
        String num[] =  {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String word[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++){
            s = s.replace(word[i], num[i]);
        }
        int answer = Integer.parseInt(s);
        return answer;
    }

  
  
//문제
//네오와 프로도가 숫자놀이를 하고 있습니다. 
//네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 
//프로도는 원래 숫자를 찾는 게임입니다.
  
//숫자의 일부 자릿수를 영단어로 바꾸는 예시
//1478 → "one4seveneight"
//234567 → "23four5six7"
//10203 → "1zerotwozero3"
