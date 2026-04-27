class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low=0;
        int high = arr.length-1;
        while(low<high)
        {
            int guess = (low+high)/2;
            if(arr[guess+1]<arr[guess])
            {
                high = guess;
            }
            else{
                low = guess +1;
            }
        }
        return low;
    }
}