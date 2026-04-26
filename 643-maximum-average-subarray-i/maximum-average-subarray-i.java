class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int low=0;
        int high= k-1;
        int sum=0;
        double average=0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<=high; i++)
        {
             sum = sum + nums[i];
        }
        while(high<n)
        {
            res = Math.max(res,sum);
            low++;
            high++;
            sum = sum -nums[low-1];
            if(high==n)
            {
                break;
            }
            else{
                sum = sum + nums[high];
            }
        }
        average = (double)res/k;
        return average;
    }
}