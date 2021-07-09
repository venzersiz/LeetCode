class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int x = 0, y = 0;
        
        OUT:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    x = i;
                    y = j;
                    break OUT;
                }
            }
        }
        
        return new int[] {x, y};
    }
}