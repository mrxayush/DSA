class Solution {
    int fun(int[][] matrix , int norow , int nocol , int guess)
    {
        int row = norow -1;
        int col = 0;
        int count =0;
    while(row>=0 && col<nocol){
        if(matrix[row][col]>guess)
        {
            row--;
        }
        else{
            count = count +(row+1);
            col++;
        }
    }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int norow = matrix.length;
        int nocol = matrix[0].length;
        int res = -1;

        int low = matrix[0][0];
        int high = matrix[norow-1][nocol-1];
        while(low<=high)
        {
            int guess = (low+high)/2;
            int ans = fun(matrix,norow,nocol,guess);
            if(ans<k)
            {
                low = guess +1;
            }
            else{
                res = guess;
                high = guess -1;
            }
        }
        return res;
    }
}