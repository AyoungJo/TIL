import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = Integer.toString(n);		
		int len = num.length();		
		int[] list = new int[len];		
		
		for(int i=0; i<len; i++) {
			list[i] = num.charAt(i) - '0';
			answer += list[i];
		}

        return answer;
    }
}

//문제
//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
