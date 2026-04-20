class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if (intervals.length == 0) {
    return new int[][]{newInterval};
}

        List<int[]> result = new ArrayList<>();
        boolean insert = false;
        for(int i =0 ; i<intervals.length;i++)
        {
            int start1 = intervals[i][0];
            if(insert==false && start1> newInterval[0])
            {
                result.add(newInterval);
                insert = true;
            }
            result.add(intervals[i]);
        }

         if (!insert) {
            result.add(newInterval);
        }

        int[][] insertedArray = result.toArray(new int[result.size()][]);

        List<int[]> ans = new ArrayList<>();

        int start1 = insertedArray[0][0];
        int end1 = insertedArray[0][1];

        for(int i =1;i<insertedArray.length;i++)
        {
            int start2 = insertedArray[i][0];
            int end2 = insertedArray[i][1];
            if(end1>= start2)
            {
                end1 = Math.max(end1 , end2);
                continue;
            }
            else{
                ans.add(new int[]{start1 , end1});
                start1 = start2;
                end1 = end2;
            }
        }
         ans.add(new int[]{start1 , end1});

         return ans.toArray(new int[ans.size()][]);
    }
}