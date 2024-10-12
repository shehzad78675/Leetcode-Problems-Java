class Solution {
    public boolean subsetSum(int i, int[] nums, int target, int[][] dp){
        if(target == 0){
            return true;
        }

        if(i == 0){
            return target == nums[0];
        }

        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }

        boolean notPick = subsetSum(i-1, nums, target, dp);
        boolean pick = false;
        if(nums[i] <= target){
            pick = subsetSum(i-1, nums, target-nums[i], dp);
        }

        if(pick || notPick){
            dp[i][target] = 1;
            return true;
        }else{
            dp[i][target] = 0;
            return false;
        }
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

        int[][] dp = new int[n][(sum/2)+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return subsetSum(n-1, nums, sum/2, dp);
    }
}