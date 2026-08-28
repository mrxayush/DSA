class Solution {
    public boolean palindromhelper(int i , int j , String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i=i+1;
            j=j-1;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;
        while(i<j)
        {
            char left = s.charAt(i),
            right = s.charAt(j);
            if(left!=right)
            {
                return palindromhelper(i+1,j,s) || palindromhelper(i,j-1,s);
            }
            else{
                i=i+1;
                j=j-1;
            }
        }
        return true;
    }
}