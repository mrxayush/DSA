class Solution {
    boolean fun(int[] nums , int n , int guess , int k )
    {
        int noofarray = 1;
        int sum =0;
        for(int i =0;i<nums.length;i++)
        {
            if(sum+nums[i]<=guess)
            {
                sum = sum+nums[i];
            }
            else{
                noofarray++;
                sum = nums[i];
                if(noofarray>k)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int totalsum=0;
        for(int i =0;i<nums.length;i++)
        {
            totalsum = totalsum+nums[i];
        }
        int low = Arrays.stream(nums).max().getAsInt();
        int high = totalsum;
        int res =-1;
        while(low<=high)
        {
            int guess = (low+high)/2;
            if(fun(nums,n,guess,k)){
                res = guess;
                high = guess -1;
            }
            else{
                low = guess +1;
            }
        }
        return res;  
    }
}