class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0,
        max=0;
        Map<Integer,Integer> map = new HashMap<>();
        int dup=0;
        for(int i=0;i<k;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
            sum=sum+nums[i];
            if(map.get(nums[i])>1)
            {
                dup=dup+1;
            }
        }
        if(dup==0)
        {
            max=Math.max(max,sum);
        }
        for(int i=k ;i<nums.length;i++)
        {
            int numtoadd=nums[i];
            int numtoremove=nums[i-k];
            if(map.containsKey(numtoadd))
            {
                map.put(numtoadd,map.get(numtoadd)+1);
            }
            else{
                map.put(numtoadd,1);
            }
            if(map.get(numtoadd)>1)
            {
                dup=dup+1;
            }
            sum=sum+numtoadd;

            if(map.get(numtoremove)>1)
            {
                dup=dup-1;
            }
            map.put(numtoremove,map.get(numtoremove)-1);
            sum=sum-numtoremove;
            if(dup==0)
            {
                max=Math.max(sum,max);
            }
        }
        return max;
    }
}