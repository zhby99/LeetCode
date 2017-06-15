public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-3; i++){
            if(i!=0){
                if(nums[i]==nums[i-1]){
                   continue;
                }
            }
            for( int j = i+1; j< nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int prev = nums[i]+nums[j];
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    if(prev + nums[left] + nums[right] < target){
                        left++;
                    } else if(prev + nums[left] + nums[right] > target){
                        right--;
                    } else{
                        List<Integer> newList = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(newList);
                        left++;
                        right--;
                        while(nums[left] == nums[left-1] && left<right){
                            left++;
                        }
                        while(nums[right] == nums[right+1] && left<right){
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
