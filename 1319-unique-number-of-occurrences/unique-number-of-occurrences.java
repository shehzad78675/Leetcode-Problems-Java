class Solution {
    public boolean uniqueOccurrences(int[] arr) {
         HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
            }else{
                hm.put(arr[i], 1);
            }
        }

        Set<Integer> keys = hm.keySet();
        HashSet<Integer> set = new HashSet<>();
        for(int key: keys){
            set.add(hm.get(key));
        }
        return set.size() == hm.size();
    }
}