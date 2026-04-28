class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<high)
        {
          int guess = (low+high)/2;
          if(nums[guess]>nums[high])
          {
            low = guess +1;
          }
          else if(nums[guess]<nums[high])
          {
            high = guess;
          }
        }
        return nums[low];
    }
}