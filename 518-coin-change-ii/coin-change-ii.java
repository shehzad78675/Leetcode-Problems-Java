class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int tar=0; tar<=amount; tar++){
            if(tar%coins[0] == 0){
                dp[0][tar] = 1;
            }else{
                dp[0][tar] = 0;
            }
        }

        for(int i=1; i<n; i++){
            for(int tar=0; tar<=amount; tar++){
                int notTake = dp[i-1][tar];
                int take = 0;
                if(coins[i] <= tar) take = dp[i][tar-coins[i]];

                dp[i][tar] = notTake + take;
            }
        }
        return dp[n-1][amount];
    }
}