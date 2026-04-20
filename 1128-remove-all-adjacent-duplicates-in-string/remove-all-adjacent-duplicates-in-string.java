class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int i ;
        String result="";
        for(i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(st.empty())
            {
                st.push(ch);
                continue;
            }
            if(st.peek()==ch)
            {
                st.pop();
                continue;
            }
            st.push(ch);
        }
        while(!st.empty())
        {
            char c = st.peek();
            result = result +st.pop();
        }

        String ans = new StringBuilder(result).reverse().toString();
        return ans;
    }
}