class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        int prev = 0;
        int len = flowerbed.length-1;
        for(int i=0; i<len; i++){
            if(prev == flowerbed[i] && flowerbed[i] == flowerbed[i+1]){
                n--;
                flowerbed[i] = 1;
                if(n == 0){
                    return true;
                }
            }
            prev = flowerbed[i];
        }
        if(prev == 0 && flowerbed[len] == 0 && n==1){
            return true;
        }
        return false;
    }
}