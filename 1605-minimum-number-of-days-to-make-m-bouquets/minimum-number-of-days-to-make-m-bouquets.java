class Solution {
    int fun(int[] bloomDay , int m , int k,int day)
    {
        int count =0;
        int bouquet =0;
        int n = bloomDay.length;
        for(int i =0; i<n; i++)
        {
            if(bloomDay[i]<=day)
            {
                count++;
                if(count==k)
                {
                    bouquet++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return bouquet;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int totalFlower = bloomDay.length;
        int NeednoOfFlower = m *k;
        int low =1;
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int res =-1;
        if(NeednoOfFlower>totalFlower)
        {
            return -1;
        }
        while(low<=high)
        {
            int guess = (low+high)/2;
       if(fun(bloomDay,m,k,guess)>=m)
       {
        res = guess;
        high = guess -1;
       }
       else{
        low = guess+1;
       }
    }
    return res;
}
}