class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount+1];
        for(int t=0; t<=amount; t++){
            if(t%coins[0] == 0){
                dp[t] = t/coins[0];
            }else{
                dp[t] = (int) 1e9;
            }
        }

        for(int i=1; i<n; i++){
            int[] temp = new int[amount+1];
            for(int target=0; target<=amount; target++){
                int notTake = dp[target];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= target) take = 1 + temp[target-coins[i]];

                temp[target] = Math.min(notTake, take);
            }
            dp = temp;
        }
        int res = dp[amount];
        return res >= (int) 1e9 ? -1 : res;
    }
}