//dp
class Solution {
    public int solution(int[][] triangle) {        
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        //맨 꼭대기 dp 값 
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++){
            //첫번째 dp 값
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            //중간 dp값
            for(int j=1; j<=i; j++){
                dp[i][j] = 	Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }

            //마지막 dp값
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        //마지막 줄 dp 값들 중에서 최대값 저장
        for(int i=0; i<triangle.length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }

        return answer;
    }
}
