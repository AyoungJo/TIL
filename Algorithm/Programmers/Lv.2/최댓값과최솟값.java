class Solution {
    public String solution(String s) {
        String answer = "";

        // 1. 공백으로 잘라서 배열에 저장
        String[] nums = s.split(" ");

        // 2. 최솟값, 최댓값 초기화
        int min = Integer.parseInt(nums[0]);
        int max = Integer.parseInt(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int compare = Integer.parseInt(nums[i]);

            // 최솟값
            if (compare < min) {
                min = compare;
            }

            // 최댓값
            if (compare > max) {
                max = compare;
            }
        }

        // 3. 최솟값과 최댓값을 문자열로 반환
        answer = min + " " + max;

        return answer;
    }
}
