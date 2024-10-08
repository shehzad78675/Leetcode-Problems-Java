class Solution {
    public int solve(int[] nums){
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;

        for(int i=1; i<n; i++){
            prev2 = nums[i] + prev2;

            int curr = Math.max(prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
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

        return Math.max(solve(temp2), solve(temp1));
    }
}