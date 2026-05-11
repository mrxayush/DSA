class Pair<K, V> {
    K first;
    V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair<Integer,Integer>[] pairChoice = new Pair[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            pairChoice[i]=new Pair<>(capital[i],profits[i]);
        }
        Arrays.sort(pairChoice, (p1, p2) -> Integer.compare(p1.first, p2.first));
        int idx =0;
        while(k-- > 0)
        {
        while(idx<n)
        {
            if(pairChoice[idx].first>w)
            {
                break;
            }
            else
            {
                pq.offer(pairChoice[idx].second);
                idx++;
            }
        }
        if(pq.isEmpty())
    {
        break;
    }
        int top = pq.peek();
        pq.poll();
        w = w + top;
    }
    return w;
    }   
}