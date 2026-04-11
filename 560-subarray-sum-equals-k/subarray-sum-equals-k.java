class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum =0;
        int count =0;
        HashMap<Integer , Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i = 0; i<nums.length; i++)
        {
            sum = sum + nums[i];
            int need = sum -k;
            if(mpp.containsKey(need)){
                count+=mpp.get(need);
            }
            if(mpp.containsKey(sum))
            {
                mpp.put(sum , mpp.get(sum)+1);
            }
            else{
            mpp.put(sum , 1);
            }
        }
        return count;
    }
}