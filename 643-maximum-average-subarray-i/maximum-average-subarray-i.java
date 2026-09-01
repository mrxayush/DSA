class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int high;
        int n = nums.length;
        int low =0;
        int sum=0;
        double avg = 0.0;
        double res = Integer.MIN_VALUE;
        for(high=0;high<k;high++)
        {
            sum=sum+nums[high];
        }
        while(high<n)
        {
            avg=(double)sum/k;
            res=Math.max(res,avg);
            sum=sum+nums[high];
            sum=sum-nums[low];
            low=low+1;
            high=high+1;
        }
        res=Math.max(res,(double)sum/k);
        return res;
    }
}