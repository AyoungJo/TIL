class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=2; i<n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            } 
        }
        return answer;
    }
}

/*문제*/
//자연수 n이 매개변수로 주어집니다. 
//n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 
//답이 항상 존재함은 증명될 수 있습니다.

//n이랑 가까운 수부터 1까지 값을 줄여가며 비교하는 코드로 1차 풀이를 했으나
//매우 비효율적이라고 느꼈고 간단하게 0과 1을 제외한 작은 수부터 단계를 거치는 것이
//효율적이라고 생각하여 코드를 다시 작성하였더니 아주 간결하고 불필요한 코드를 줄이는 코드로 풀이할 수 있었습니다.
/*class Solution {
    public int solution(int n) {
        int answer = 0;
        int min = 0;
        for(int i = n-1; i>=1; i--){
            if(n % i == 1){
                answer = i;
                min = n;
                if(min < answer){
                    int temp = min;
                    min = answer;
                    answer = temp;
                }
            }            
        }
        
        return answer;
    }
}*/
