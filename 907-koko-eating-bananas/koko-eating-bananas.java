class Solution {
    long fun(int[] piles , int n ,int speed)
    {
        int len = piles.length;
        long res=0;
        for(int i =0;i<len;i++)
        {
            res = res + piles[i]/speed;
            if(piles[i]%speed!=0)
            {
                res++;
            }
        }
    return res;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low =1;
        int high = Arrays.stream(piles).max().getAsInt(); 
        int res = -1;
        while(low<=high)
        {
            int guess = (low + high)/2;
            long hour = fun(piles,n,guess);
            if(hour>h)
            {
                low = guess+1;
            }
            else{
                res = guess;
                high = guess -1;
            }
        }
        return res;
    }
}