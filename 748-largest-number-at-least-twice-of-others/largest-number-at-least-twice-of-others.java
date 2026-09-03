class Solution {
    public int dominantIndex(int[] nums) {
        int max =nums[0];
        int index =0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index =i;
            }
        }
       // boolean twice = false;
        for(int i=0;i<nums.length;i++)
        {
            if(max==nums[i])
            {
                continue;
            }
            else if(max<nums[i]*2)
            {
                return -1;
            }
        }
        return index;
    }
}