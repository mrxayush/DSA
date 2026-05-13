class Pair
{
    int freq;
    char ele;

    Pair(int freq , char ele)
    {
        this.freq = freq;
        this.ele = ele;
    }
}

class Solution {

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> mpp = new HashMap<>();
        HashMap<Character,Integer> register = new HashMap<>();

        for(int i =0;i<tasks.length;i++)
        {
            register.put(tasks[i],1);

            if(mpp.containsKey(tasks[i]))
            {
                mpp.put(tasks[i],mpp.get(tasks[i])+1);
            }
            else{
                mpp.put(tasks[i],1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.freq!=b.freq)
                {
                    return b.freq - a.freq;
                }
                else{
                    return b.ele - a.ele;
                }
            }
        );

        for(Map.Entry<Character,Integer> it : mpp.entrySet())
        {
            char element = it.getKey();
            int frequency = it.getValue();

            Pair curr = new Pair(frequency , element);

            pq.offer(curr);
        }

        int seat =1;

        while(!pq.isEmpty())
        {
            List<Pair> pulled = new ArrayList<>();

            while(!pq.isEmpty())
            {

                Pair p = pq.poll();

                int fr = p.freq;

               
                char task = p.ele;

                if(register.get(task)<=seat)
                {
                    fr--;

                    register.put(task,seat+n+1);

                    if(fr>0)
                    {
                        pq.offer(new Pair(fr,task));
                    }

                    break;
                }
                else{
                    pulled.add(p);
                }
            }

            for(Pair x : pulled)
            {
                pq.offer(x);
            }

            seat++;
        }

        return seat-1;
    }
}