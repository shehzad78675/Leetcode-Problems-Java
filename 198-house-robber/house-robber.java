class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int temp1 = nums[0];
        int temp2 = 0;

        for(int i=1; i<n; i++){
            temp2 = nums[i] + temp2;

            int curr = Math.max(temp2, temp1);
            temp2 = temp1;
            temp1 = curr;
        }
        return temp1;
    }
}