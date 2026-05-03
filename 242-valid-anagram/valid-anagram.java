class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> maps = new HashMap<>();
        HashMap<Character,Integer> mapt = new HashMap<>();

        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(maps.containsKey(ch))
            {
                maps.put(ch,maps.get(ch)+1);
            }
            else{
                maps.put(ch,1);
            }
        }
        for(int i =0;i<t.length();i++)
        {
             char ch = t.charAt(i);
            if(mapt.containsKey(ch))
            {
                mapt.put(ch,mapt.get(ch)+1);
            }
            else{
                mapt.put(ch,1);
            }
        }
        return maps.equals(mapt);
    }
}