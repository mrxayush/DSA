class Solution {
    HashMap<Integer,Integer> dp = new HashMap<>();
    public int climbStairs(int n) {
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 0;
        }
        if(dp.containsKey(n))
        {
            return dp.get(n);
        }
        int ans1 = climbStairs(n-1);
        int ans2 = climbStairs(n-2);
        int anss = ans1+ans2;
        dp.put(n,anss);
        return anss;
    }
}