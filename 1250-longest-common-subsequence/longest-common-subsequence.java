class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[] dp = new int[n2+1];
        for(int i=1; i<=n1; i++){
            int[] temp = new int[n2+1];
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                }else{
                    temp[j] = Math.max(dp[j], temp[j-1]);
                }
            }
            dp = temp;
        }

        return dp[n2];
    }
}