class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int nums:arr)
        {
            if(set.contains(nums*2)||(set.contains(nums/2) && nums%2==0))
            {
                return true;
            }
            else{
                set.add(nums);
            }
        }
        return false;
    }
}