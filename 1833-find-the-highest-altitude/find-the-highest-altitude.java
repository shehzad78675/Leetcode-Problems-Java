class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
		int[] arr = new int[gain.length + 1];
		
		for(int i=0; i<gain.length; i++) {
			 if(i == 0) {
				 arr[i] = 0;
				 arr[i+1] = gain[i];
			 }else {
				 arr[i+1] = arr[i]+gain[i];
			 }
			 
		}
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
                max = arr[i];
			}
		}
		return max;
    }
}