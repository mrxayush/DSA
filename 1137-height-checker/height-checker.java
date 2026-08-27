class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            res[i]=heights[i];
        }
        Arrays.sort(res);
        for(int i=0;i<n;i++)
        {
            if(heights[i]!=res[i])
            {
                count++;
            }
        }
        return count;
    }
}