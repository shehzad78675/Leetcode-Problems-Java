class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int cnt = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                cnt++;
            }
            if((r-l+1) > k){
                char ch1 = s.charAt(l);
                if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u'){
                    cnt--;
                }
                l++;
            }
            ans = Math.max(ans, cnt);
            r++;
        }
        return ans;
    }
}