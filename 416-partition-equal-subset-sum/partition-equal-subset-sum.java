class Solution {
    public boolean subsetSum(int[] nums, int k){
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= k){
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int target=1; target<=k; target++){
                boolean notPick = dp[i-1][target];
                boolean pick = false;
                if(nums[i] <= target) pick = dp[i-1][target-nums[i]];

                dp[i][target] = pick || notPick;
            }
        }
        return dp[n-1][k];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        if(sum%2 == 1){
            return false;
        }
        
        return subsetSum(nums, sum/2);
    }
}