class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int [] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0; i--)
        {

            while(!st.empty() && temp[st.peek()]<=temp[i])
            {
                st.pop();
            }
            if(st.empty())
            {
                result[i] = 0;
            }

            else{
                result[i] = st.peek()-i;
            }

            st.push(i);
        }
        return result;
    }
}