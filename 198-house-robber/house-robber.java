class Solution {
    public int solve(int[] nums, int ind, int[] dp){
        if(ind == 0){
            return nums[ind];
        }

        if(ind < 0){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }
        int pickIn = nums[ind] + solve(nums, ind-2, dp);
        int notPickIn = 0 + solve(nums, ind-1, dp);

        return dp[ind] = Math.max(pickIn, notPickIn);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, n-1, dp);
    }
}