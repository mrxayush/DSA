class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int n = ransomNote.length();
        int m = magazine.length();
        for(int i =0; i<n; i++)
        {
             char ch = ransomNote.charAt(i);
            if(map1.containsKey(ch))
            {
                map1.put(ch,map1.get(ch)+1);
            }
            else{
                map1.put(ch,1);
            }
        }
        for(int i=0; i<m; i++)
        {
            char chm = magazine.charAt(i);
            if(map2.containsKey(chm))
            {
                map2.put(chm,map2.get(chm)+1);
            }
            else{
                map2.put(chm,1);
            }
        }
       for(char ch : map1.keySet())
       {
        int need = map1.get(ch);
        int available = map2.getOrDefault(ch , 0);
        if(available < need)
        {
            return false;
        }
       }
       return true;
    }
}