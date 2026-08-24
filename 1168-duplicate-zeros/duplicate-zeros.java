class Solution {
    public void duplicateZeros(int[] arr) {
        int countzero=0;
        int n =arr.length;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                countzero++;
            }
        }
        int i = n-1;
        int j=n+countzero-1;
        while(i>=0)
        {
            int val = arr[i];
            if(j<n)
            {
                arr[j]=val;
            }
            j--;
            if(val==0)
            {
                if(j<n)
                {
                    arr[j]=0;
                }
                j--;
            }
            i--;
        }
    }
}