class Solution {
    public int sum(int[] arr){
        return arr[0] + arr[1] + arr[2];
    }
    public int tribonacci(int n) {
        int tri[] = {0, 1, 1};
        if(n < 3){
            return tri[n];
        }

        for(int i=3; i<=n; i++){
            int sum = sum(tri);
            tri[0] = tri[1];
            tri[1] = tri[2];
            tri[2] = sum;
        }
        return tri[2];
    }
}