class Solution {
    public int maxProduct(int[] nums) {
        double ans = nums[0];
        double currLeftP = 1;
        double currRightP = 1;

        int n = nums.length;

        for(int i=0; i<nums.length; i++){
            if(currRightP == 0){
                currRightP = 1;
            }
            if(currLeftP == 0){
                currLeftP = 1;
            }

            currLeftP *= nums[i];
            currRightP *= nums[n-1-i];
            ans = Math.max(ans, Math.max(currRightP, currLeftP));
            
        }

        return (int)ans;
    }
}