class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum =0;
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0;i<n;i++)
        {
            sum = sum + nums[i];
            int need = sum -goal;
            if(map.containsKey(need))
            {
                ans = ans + map.get(need);
                
            }
            if(map.containsKey(sum))
            {
                map.put(sum , map.get(sum)+1);
            }
            else{
                map.put(sum ,1);
            }
        }
        return ans;
    }
}