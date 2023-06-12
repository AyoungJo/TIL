class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int num = x;
        
        while(num>0){
            sum += num%10;
            num /=10;
        }
         
        return (x%sum == 0?true:false);
    }
}


////////////////////////////////////////////////
/*class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String num = String.valueOf(x);
        String[] numArr = num.split("");
        
        for(String number : numArr){
            sum += Integer.parseInt(number);
        }        
        
        return ( x % sum == 0? true : false);
    }
}*/
