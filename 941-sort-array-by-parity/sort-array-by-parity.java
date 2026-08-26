class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int x =0;
        for(int i =0;i<n;i++)
        {
            if(arr[i]%2!=0)
            {
                continue;
            }
            else{
                res[x]=arr[i];
                x++;

        }
        }
        for(int j=0;j<n;j++)
        {
            if(arr[j]%2!=0)
            {
                res[x]=arr[j];
                x++;
            }
        }
        return res;
    }
}

