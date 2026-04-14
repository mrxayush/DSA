class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0; i<nums.length;i++)
        {
            if(nums[i]%2 !=0)
            {
                 count++;
            }
            int need = count-k;
            if(map.containsKey(need))
            {
                ans = ans + map.get(need);
            } 
            if(map.containsKey(count))
            {
                map.put(count , map.get(count)+1);
            }
            else{
                map.put(count , 1);
            }
        }
        return ans;
    }
}