class Solution {
    int first(int[] arr , int target){
         int n = arr.length;
     int low =0;
     int high = n-1; 
     int first = -1; 
        while(low<=high){
            int guess = (low+high)/2;
            if(arr[guess]==target)
            {
                first = guess;
                high = guess -1;
            }
        else if(arr[guess]<target)
        {
            low = guess +1;
        }
        else{
        high = guess -1;
        }
    }
     return first;
    }
     int last(int[] arr , int target){
         int n = arr.length;
     int low =0;
     int high = n-1; 
     int last= -1; 
        while(low<=high){
            int guess = (low+high)/2;
            if(arr[guess]==target)
            {
                last = guess;
                low = guess +1;
            }
        else if(arr[guess]<target)
        {
            low = guess +1;
        }
        else{
            high = guess -1;
        }
        }
        return last;
    }
    public int[] searchRange(int[] arr, int target) {
    
    int firstIdx = first(arr, target);
    int lastIdx = last(arr ,  target);

        return new int[]{firstIdx , lastIdx};
    }
}