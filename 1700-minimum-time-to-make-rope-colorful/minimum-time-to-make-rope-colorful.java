class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        for(int i=1; i<neededTime.length; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                int currMinTime = Math.min(neededTime[i], neededTime[i-1]);
                minTime += currMinTime;
                if(currMinTime == neededTime[i]){
                    neededTime[i] = neededTime[i-1];
                    neededTime[i-1] = currMinTime;
                }
            }
        }
        return minTime;
    }
}