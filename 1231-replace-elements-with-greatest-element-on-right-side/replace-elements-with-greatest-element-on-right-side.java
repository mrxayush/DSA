class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int m =-1;
        int temp = arr[n-1];
        arr[n-1]=m;
        int res = Integer.MIN_VALUE;
        for(int i = n-2;i>=0;i--)
        {
            res = Math.max(m,temp);
            temp = arr[i];
            arr[i]=res;
            m=res;
        }
        return arr;
    }
}