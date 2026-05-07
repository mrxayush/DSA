class Pair {
    int freq;
    int value;

    Pair(int freq , int value)
    {
        this.freq = freq;
        this.value = value;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i =0;i<nums.length;i++)
        {
            if(mpp.containsKey(nums[i]))
            {
            mpp.put(nums[i],mpp.get(nums[i])+1);
            }
            else{
                mpp.put(nums[i],1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.freq!=b.freq)
                {
                return a.freq - b.freq;    
                }
            else{
                return a.value - b.value;
            }
            }
        );

         for(Map.Entry<Integer,Integer> it : mpp.entrySet())
         {
            int element = it.getKey();
            int frequency = it.getValue();
            Pair curr = new Pair(frequency,element);
         if(pq.size()<k)
         {
            pq.add(curr);
            continue;
         }
         else if(curr.freq<pq.peek().freq)
         {
            continue;
         } 
         else{
            pq.poll();
            pq.add(curr);
         }
         }   
        int[] ans = new int[k];
        int ansIdx = 0;
        while(!pq.isEmpty())
        {
            ans[ansIdx]=pq.poll().value;
            ansIdx++;
        } 
        return ans;
    }
}