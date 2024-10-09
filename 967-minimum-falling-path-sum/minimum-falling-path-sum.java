class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = matrix[0][i];
        }

        for(int i=1; i<n; i++){
            int temp[] = new int[n];
            for(int j=0; j<n; j++){
                int up = matrix[i][j] + dp[j];
                int ld = matrix[i][j];
                int rd = matrix[i][j];

                if(j > 0) ld += dp[j-1];
                else ld += (int) 1e9;
                if(j+1 < n) rd += dp[j+1];
                else rd += (int) 1e9;

                temp[j] = Math.min(up, Math.min(ld, rd));
            }
            dp = temp;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(dp[i], min);
        }

        return min;
    }
}