class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        for(int tar=0; tar<=amount; tar++){
            if(tar%coins[0] == 0){
                dp[tar] = 1;
            }else{
                dp[tar] = 0;
            }
        }

        for(int i=1; i<n; i++){
            int temp[] = new int[amount+1];
            for(int tar=0; tar<=amount; tar++){
                int notTake = dp[tar];
                int take = 0;
                if(coins[i] <= tar) take = temp[tar-coins[i]];

                temp[tar] = notTake + take;
            }
            dp = temp;
        }
        return dp[amount];
    }
}