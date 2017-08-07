public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        Set<Integer> remains = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new HashSet<>());
            map2.put(i, new LinkedList<>());
            remains.add(i);
        }
        for(int[] depend: prerequisites){
            map.get(depend[0]).add(depend[1]);
            map2.get(depend[1]).add(depend[0]);
        }
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i : remains){
            if(map.get(i).size() == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int i = queue.poll();
            res[index++] = i;
            remains.remove(i);
            for(int j : map2.get(i)){
                map.get(j).remove(i);
                if(map.get(j).size()==0){
                    queue.offer(j);
                }
            }
        }
        if(index != numCourses){
            return new int[]{};
        }
        return res;
    }
}
