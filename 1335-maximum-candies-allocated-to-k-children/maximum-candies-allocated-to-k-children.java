class Solution {
    long fun(int[] candies , int n , long k , int guess)
    {
        int len = candies.length;
        long Totalchild = 0;
        for(int i =0;i<len;i++)
        {
            int ques = candies[i]/guess;
            Totalchild = Totalchild +ques;
        }
    return Totalchild;
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int low =1;
        int high = Arrays.stream(candies).max().getAsInt();
        int res = 0;
        while(low<=high)
        {
            int guess =(low+high)/2;
            long noOfChild = fun(candies , n , k , guess);
            if(noOfChild>=k)
            {
                res = guess;
                low= guess +1;
            }
            else{
                high = guess-1;
            }
        }
        return res;
    }
}