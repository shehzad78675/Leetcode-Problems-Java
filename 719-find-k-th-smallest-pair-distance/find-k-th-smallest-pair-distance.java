class Solution {
    public int sliding(int diff, int[] nums, int n){
        int j = 0;
        int cnt = 0;
        for(int i=1; i<n; i++){
            while(nums[i] - nums[j] > diff){
                j++;
            }
            
            cnt += i-j; 
        }
        return cnt;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int high = nums[n-1] - nums[0];
        int low = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            if(nums[i] - nums[i-1] < low){
                low = nums[i] - nums[i-1];
            }
        }

        while(low < high){
            int mid = low + (high - low)/2;
            int ans = sliding(mid, nums, n);

            if(ans < k){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}