class Solution {
    public boolean subsetSum(int[] nums, int k){
        int n = nums.length;
        boolean[] dp = new boolean[k+1];

        dp[0] = true;

        if(nums[0] <= k){
            dp[nums[0]] = true;
        }

        for(int i=1; i<n; i++){
            boolean temp[] = new boolean[k+1];
            temp[0] = true;
            for(int target=1; target<=k; target++){
                boolean notPick = dp[target];
                boolean pick = false;
                if(nums[i] <= target) pick = dp[target-nums[i]];

                temp[target] = pick || notPick;
            }
            dp = temp;
        }
        return dp[k];
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