class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        

        int nvals[] = new int[26];

        for(int j = 1 ; j <= 26 ; j++){
            nvals[j-1] = j;
        }
        int i = 0;


        for(char ch :chars.toCharArray() ){
            nvals[ch - 'a'] = vals[i++];
        }


        int maxsum =0;
        int currsum=0;
        int k = 0;
        for(char ch : s.toCharArray()){


            currsum += nvals[ch-'a'];

           if(currsum>maxsum){
            maxsum = currsum;
           }
            if(currsum < 0){
                currsum=0;
            }
        }



     return maxsum;
    }
}