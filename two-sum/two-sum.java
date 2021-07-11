class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int idx1 = 0, idx2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            Integer idxOfAnotherValue = map.get(target - currentValue);
            
            if (idxOfAnotherValue == null) {
                map.put(currentValue, i);
            } else {
                idx1 = i;
                idx2 = idxOfAnotherValue;
                break;
            }
        }
        
        return new int[] {idx1, idx2};
    }
}