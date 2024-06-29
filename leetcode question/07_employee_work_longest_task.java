class Solution {
    public int hardestWorker(int n, int[][] logs) {
      
        int max = logs[0][1];
        int id = logs[0][0];
        //just traverse and keep track of larger unit time and
        //if they are equal then update our id to smaller within them
        for(int i = 1; i < logs.length ; i++){
            if(max <= logs[i][1]-logs[i-1][1]){
                if(max == logs[i][1]-logs[i-1][1]){
                    id = Math.min(id,logs[i][0]);
                }
                else{
                    max = Math.max(max,logs[i][1]-logs[i-1][1]);
                    id = logs[i][0];
                }
            }
        }
        
        return id;
    }
}