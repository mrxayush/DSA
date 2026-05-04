class Solution {
    int fun(int[][] matrix , int target , int guess)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0; 
        int high = row-1;
        int ans =0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(matrix[mid][0]<=target)
            {
                ans = mid;
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return ans;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = col-1;
        int rowidx = fun(matrix , target , 0);
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(matrix[rowidx][mid]==target)
            {
                return true;
            }
            else if(matrix[rowidx][mid]<target)
            {
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return false;
    }
}