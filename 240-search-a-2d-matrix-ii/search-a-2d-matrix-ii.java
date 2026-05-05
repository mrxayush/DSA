class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;

        int row = totalRow -1;
        int col = 0;
        while(row>=0 && col < totalCol)
        {
            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]>=target)
            {
                row--;
            }
            else{
                col++;
            }
        }
        return false;
    }
}