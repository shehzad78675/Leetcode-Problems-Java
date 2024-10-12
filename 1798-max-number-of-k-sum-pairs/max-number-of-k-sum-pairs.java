class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;

        int cnt = 0;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum == k){
                cnt++;

                start++;
                end--;
            }else if(sum < k){
                start++;
            }else{
                end--;
            }
        }
        return cnt;
    }
}