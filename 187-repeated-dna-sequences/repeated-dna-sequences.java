class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        int n = s.length();
        for(int i=0;i<=n-10;i++)
        {
            String subr = s.substring(i,i+10);
            if(set.contains(subr))
            {
                result.add(subr);
            }
            else{
                set.add(subr);
            }
        }
        return new ArrayList<String>(result);
    }
}