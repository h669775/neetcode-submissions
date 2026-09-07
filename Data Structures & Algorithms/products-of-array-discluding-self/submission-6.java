class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        
        // pass 1: Everything to the LEFT of i
        prefix[0] = 1; // if 0, the whole new array would be 0
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        //pass 2: Product of everything to the right of i together with the prefix
        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix[i] *= suffix;
            suffix *= nums[i];
        }
        return prefix;
    }
}  
