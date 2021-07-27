class Solution {
    public int maxSubArray(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int maxSubArray = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxSubArray = nums[i];
            }

            int sum = nums[i];
            int max = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[j];
                if (num > 0) {
                    if (sum + num > maxSubArray) {
                        maxSubArray = sum + num;
                    }
                    if (num > max) {
                        max = num;
                    }
                } else if (maxSubArray < 0 && num > maxSubArray) {
                    maxSubArray = num;
                }

                sum = sum + num;

                if (sum > maxSubArray) {
                    maxSubArray = sum;
                }
            }

            if (maxSubArray < max) {
                maxSubArray = max;
            }
        }

        return maxSubArray;
    }
}