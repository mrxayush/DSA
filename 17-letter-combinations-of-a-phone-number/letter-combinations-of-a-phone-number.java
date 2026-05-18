class Solution {
    HashMap<Character,String> mpp = new HashMap<>();
    public List<String> letterCombinations(String digits) {
           mpp.put('2',"abc");
        mpp.put('3',"def");
        mpp.put('4',"ghi");
        mpp.put('5',"jkl");
        mpp.put('6',"mno");
        mpp.put('7',"pqrs");
        mpp.put('8',"tuv");
        mpp.put('9',"wxyz");
        int n = digits.length();
        List<String> res = new ArrayList<>();
    fun( digits ,  n , 0 , new StringBuilder(), res );
    return res;
    }
    void fun(String digits , int n , int idx , StringBuilder diary , List<String> res)
{
    if(idx==n)
    {
        res.add(diary.toString());
        return ;
    }
    String choice = mpp.get(digits.charAt(idx));
    for(int j =0;j<choice.length();j++)
    {
        diary.append(choice.charAt(j));
        fun(digits,n,idx+1,diary,res);
        diary.deleteCharAt(diary.length()-1);
    }
    return ;
}
}
