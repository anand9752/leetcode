class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        
        for(int i = 0 ; i<employees.size() ; i++){
            map.put(employees.get(i).id , employees.get(i));
        }
        return dfs(id);
    }

   public int dfs(int id){

      
      int totalsum = 0;
      totalsum += map.get(id).importance;
      for(int nid: map.get(id).subordinates){
         totalsum += dfs(nid);
      }



      return totalsum;
   }
}