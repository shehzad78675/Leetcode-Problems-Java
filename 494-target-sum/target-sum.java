class Solution {
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

        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0] != 0 && nums[0] <= k) dp[0][nums[0]] = 1;
        for(int i=1; i<n; i++){
            for(int tar=0; tar<=k; tar++){
                int notTake = dp[i-1][tar];
                int take = 0;
                if(nums[i] <= tar) take = dp[i-1][tar-nums[i]];

                dp[i][tar] = take + notTake;
            }
        }
        return dp[n-1][k];
    }
}