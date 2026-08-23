class Solution {
    public int findNumbers(int[] nums) {
        int n =nums.length;
        int nocount=0;
        for(int i=0;i<n;i++)
        {
            int no=nums[i];
            int count=0;
            while(no>0)
            {
                int digit=no%10;
                count++;
                no=no/10;
            }
            if(count%2==0)
            {
                nocount++;
            }
        }
        return nocount;
    }
}