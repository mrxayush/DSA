class Solution {
    boolean fun(int[] position , int n , int m , int guess)
    {
        int ball = 1;
        int pos = position[0];
        for(int i =1;i<position.length;i++)
        {
            int force = position[i] - pos;
            if(force<guess)
            {
                continue;
            }
            else{
                ball++;
                pos = position[i];
            }
        }
        if(ball>=m)
        {
            return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int low =1;
        int high = position[n-1] - position[0];
        int res =-1;
        while(low<=high)
        {
            int guess = (low+high)/2;
            if(fun(position , n , m , guess))
            {
                res = guess;
                low = guess+1;
            }
            else{
                high = guess -1;
            }
        }
        return res;
    }
}