class Solution {
    public int pivotIndex(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        int leftSum = 0;
        for(int i=0; i<arr.length; i++){
            
            sum -= arr[i];
            if(leftSum == sum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}