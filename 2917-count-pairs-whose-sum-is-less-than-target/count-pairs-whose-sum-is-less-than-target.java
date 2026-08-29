class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int i=0;
        int j = n-1;
        int sum =0;
        int count=0;
        while(i<j)
        {
            sum = nums.get(i)+ nums.get(j);
            if(sum<target)
            {
                count = count+(j-i);
                i=i+1;
            }
            else{
                j =j-1;
            }
        }
        return count;
    }
}