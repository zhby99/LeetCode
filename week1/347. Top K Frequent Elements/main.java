public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] myList = new List[nums.length + 1];
    	Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();

	    for (int n : nums) {
	    	myMap.put(n, myMap.getOrDefault(n, 0) + 1);
	    }

	    for (int key : myMap.keySet()) {
		    int counts = myMap.get(key);
		    if (myList[counts] == null) {
			    myList[counts] = new ArrayList<>();
		    }
		    myList[counts].add(key);
	    }

	    ArrayList<Integer> res = new ArrayList<>();
	    for(int i = myList.length - 1; i >= 0 && res.size() < k; i--){
	        if (myList[i] != null) {
	            if(myList[i].size()<=k-res.size()){
			        res.addAll(myList[i]);
	            }
	            else{
	                for(int j=0;j<k-res.size(); j++){
	                    res.add(myList[i].get(j));
	                }
	            }
		    }
	    }
	    return res;

    }
}
