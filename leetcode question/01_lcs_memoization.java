class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m+1][n+1];
        for(int[] x :dp){
            Arrays.fill(x,-1);
        }


        return lcs(text1,text2,m,n,dp);
    }


    public int lcs(String t1,String t2 , int m , int n , int dp[][]){
       
       if(m==0 || n==0) return 0;


       if(dp[m][n] != -1){
        return dp[m][n];
       }


       if(t1.charAt(m-1) == t2.charAt(n-1)){
           return dp[m][n] =  1+ lcs(t1,t2,m-1,n-1,dp);
       } 
       
       dp[m][n] = Math.max(lcs(t1, t2, m, n - 1, dp),
                            lcs(t1, t2, m - 1, n, dp));
        return dp[m][n];


    }
}