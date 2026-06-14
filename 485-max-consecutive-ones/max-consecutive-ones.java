class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter_one =0;
        int res =0;
        int n = nums.length;
        int j = 0;
        while(j<n)
        {
            if(nums[j]==1)
            {
                counter_one++; 
                j++;
            }
            else{
                res = Math.max(res,counter_one);
                counter_one=0;
                j++;
            }
        }
         res = Math.max(res, counter_one);
         return res;
    }
}