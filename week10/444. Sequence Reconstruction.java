public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for(List<Integer> list : seqs){
            if(list.size() == 1){
                if(!map.containsKey(list.get(0))) {
                    map.put(list.get(0), new HashSet<>());
                    indegree.put(list.get(0), 0);
                }
            }else{
                for(int i = 0; i < list.size() - 1; i++){
                    if(!map.containsKey(list.get(i))) {
                        map.put(list.get(i), new HashSet<>());
                        indegree.put(list.get(i), 0);
                    }

                    if(!map.containsKey(list.get(i+1))) {
                        map.put(list.get(i+1), new HashSet<>());
                        indegree.put(list.get(i+1), 0);
                    }

                    if(map.get(list.get(i)).add(list.get(i+1))) {
                        indegree.put(list.get(i+1), indegree.get(list.get(i+1)) + 1);
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) queue.offer(entry.getKey());
        }
        int index = 0;
        while(!queue.isEmpty()){
            if(queue.size() > 1){
                return false;
            }
            int i = queue.poll();
            if(index == org.length || i != org[index++]){
                return false;
            }
            for(int j: map.get(i)){
                indegree.put(j, indegree.get(j)-1);
                if(indegree.get(j) == 0){
                    queue.offer(j);
                }
            }
        }
        return index == map.size() && index == org.length;
    }
}
    
