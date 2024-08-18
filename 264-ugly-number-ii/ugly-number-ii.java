class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> dp = new ArrayList<>();

        dp.add(1);
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for(int i=1; i<n; i++){
            int twoMultiple = dp.get(p1)*2;
            int threeMultiple = dp.get(p2)*3;
            int fiveMultiple = dp.get(p3)*5;

            int val = Math.min(twoMultiple, Math.min(threeMultiple, fiveMultiple));
            dp.add(val);

            if(dp.get(i) == twoMultiple){
                p1++;
            }
            if(dp.get(i) == threeMultiple){
                p2++;
            }
            if(dp.get(i) == fiveMultiple){
                p3++;
            }
        }
        return dp.get(n-1);
    }
}