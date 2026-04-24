class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int i;
        int power =arr[0];
        int nopower = arr[0];
        int res = arr[0];

        for(i=1;i<n;i++)
        {
            int choice1 = arr[i];
            int choice2 = nopower + arr[i];
            int choice3 = power + arr[i];
            int choice4 = nopower;

            int oldnoPower = nopower;
            nopower = Math.max(choice1 , choice2 );
            power = Math.max(choice3,oldnoPower);

            res = Math.max(res, Math.max(nopower, power));
            
        }
        return res;
}
}