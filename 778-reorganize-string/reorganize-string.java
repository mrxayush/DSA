class Pair
{
    int freq;
    char value;

    Pair(int freq , char value)
    {
        this.freq = freq;
        this.value = value;
    }
}
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> mpp = new HashMap<>();
        String ans ="";
        int seat = 0;
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(mpp.containsKey(ch))
            {
                mpp.put(ch,mpp.get(ch)+1);
            }
            else{
                mpp.put(ch,1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{ 
                if(a.freq!=b.freq)
                {
                    return b.freq - a.freq;
                }
                else{
                    return b.value - a.value;
                }
            }
        );

        for(Map.Entry<Character,Integer> it : mpp.entrySet())
        {
            char element = it.getKey();
            int frequency = it.getValue();
            Pair curr = new Pair(frequency,element);
            if(pq.size()!=mpp.size())
            {
                pq.offer(curr);
            }
        }
        while(!pq.isEmpty())
        {
            if(seat==0 || ans.charAt(seat-1)!=pq.peek().value)
            {
                ans = ans + pq.peek().value;
                seat++;
                Pair p = pq.poll();
                p.freq--;
                if(p.freq>0)
                {
                pq.offer(p);
                }
            }
            else{
                Pair temp = pq.poll();
                if(pq.isEmpty())
                {
                    return "";
                }
                ans = ans + pq.peek().value;
                seat++;
                Pair second = pq.poll();
                second.freq--;
                if(second.freq>0)
                {
                    pq.offer(second);
                }
                pq.offer(temp);
            }
        }
        return ans;
    }
}       