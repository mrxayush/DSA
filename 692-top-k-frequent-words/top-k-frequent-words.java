class Pair {
    int freq;
    String value;

    Pair(int freq , String value)
    {
        this.freq = freq;
        this.value = value;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> mpp = new HashMap<>();
        for(int i =0;i<words.length;i++)
        {
            if(mpp.containsKey(words[i]))
            {
                mpp.put(words[i],mpp.get(words[i])+1);
            }
            else{
                mpp.put(words[i],1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.freq!=b.freq)
                {
                    return a.freq-b.freq;
                }
                else{
                    return b.value.compareTo(a.value);
                }
            }
        );
        for(Map.Entry<String,Integer> it : mpp.entrySet())
        {
            String element = it.getKey();
            int frequency = it.getValue();
        Pair curr = new Pair(frequency,element);
        if(pq.size()<k)
        {
            pq.offer(curr);
            continue;
        }
        else if(curr.freq<pq.peek().freq)
        {
            continue;
        }
        else if(curr.freq==pq.peek().freq && curr.value.compareTo(pq.peek().value)<0){
            pq.poll();
            pq.offer(curr);
        }
        else if(curr.freq>pq.peek().freq)
        {
            pq.poll();
            pq.offer(curr);
        }
        }
        List<String> ls = new ArrayList<>();
        while(!pq.isEmpty())
        {
            ls.add(pq.poll().value);
        }
        Collections.reverse(ls);
        return ls;
    }
}