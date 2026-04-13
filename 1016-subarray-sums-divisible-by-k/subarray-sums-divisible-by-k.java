class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int res =0;
        HashMap<Integer , Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        for(int i =0; i<nums.length;i++)
        {
            sum=sum+nums[i];
            int remainder = sum%k;
            if(remainder<0)
            {
                remainder = remainder +k;
            }
            if(mpp.containsKey(remainder))
            {
                res = res + mpp.get(remainder);
                mpp.put(remainder , mpp.get(remainder)+1);
            }
            else{
                mpp.put(remainder , 1);
            }
        }
        return res;
    }
}