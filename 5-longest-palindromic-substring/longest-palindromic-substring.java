class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        String ans = s.substring(0, 1);
        int maxLen = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(j-i+1 > maxLen && isPalindrome(s, i, j)){
                    StringBuilder str = new StringBuilder();
                    for(int k=i; k<=j; k++){
                        str.append(s.charAt(k));
                    }
                    ans = str.toString();
                    maxLen = j-i+1;
                }
            }
        }
        return ans;
    }
}