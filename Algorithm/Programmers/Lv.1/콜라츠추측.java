class Solution {
    public int solution(int num) {
        int answer = num;
        int count = 0;

        for (int i = 0; i < 500; i++) {
            if (answer == 1) {
                break;
            } else if (answer % 2 == 0) {
                answer = answer / 2;
                count++;
                if (answer == 1) {
                    break;
                }
            } else if (answer % 2 == 1){
                answer = (answer * 3) + 1;
                count++;
                if (answer == 1) {
                    break;
                }
            }
        }

        if (answer != 1) {
            count = -1;
        }

        return count;
    }
}
