class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if(n==0) return false;
        for(int i = 2 ; i <=31 ; i+=2){
            int temp = 1<<i;
            if((n & temp) == n){
                return true;
            }
        }
        return false;
    }
}