class Solution {
    public int solve(int ind, int[] nums, int k, int[][] dp){
        if(ind == 0){
            if(k == 0 && nums[0] == k) return 2;
            if(k == 0 || nums[0] == k) return 1;
            return 0;
        }

        if(dp[ind][k] != -1){
            return dp[ind][k];
        }

        int notTake = solve(ind-1, nums, k, dp);
        int take = 0;
        if(nums[ind] <= k) take = solve(ind-1, nums, k-nums[ind], dp);

        return dp[ind][k] = take + notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }

        if(totalSum - target < 0 || (totalSum-target)%2 == 1){
            return 0;
        }

        int k = (totalSum-target)/2;
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(n-1, nums, k, dp);
    }
}