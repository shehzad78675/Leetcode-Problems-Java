class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i])+1);
            }else{
                hm.put(nums[i], 1);
            }
        }
        Set<Integer> set = hm.keySet();
        List<Integer> li = new ArrayList<>();
        for(int key: set){
            if(hm.get(key) > 1){
                li.add(key);
            }
        }
        return li;
    }
}
