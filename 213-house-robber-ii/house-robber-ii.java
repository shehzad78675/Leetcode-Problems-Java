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

        int pick = nums[ind] + solve(nums, ind-2, dp);
        int notPick = solve(nums, ind-1, dp);

        return dp[ind] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i=1; i<n; i++){
            temp1[i-1] = nums[i-1];
            temp2[i-1] = nums[i];
        }

        int[] dp = new int[n-1];
        Arrays.fill(dp, -1);
        int ans1 = solve(temp1, n-2, dp);

        Arrays.fill(dp, -1);
        int ans2 = solve(temp2, n-2, dp);

        return Math.max(ans1, ans2);
    }
}