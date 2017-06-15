public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int minDistance = -1;
        int sum = 0;
        for(int i = 0; i < nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int currentDistance = distance(nums[i]+nums[left]+nums[right],target);
                if(minDistance < 0){
                    minDistance = currentDistance;
                    sum = nums[i]+nums[left]+nums[right];
                } else{
                    if(currentDistance < minDistance){
                        sum = nums[i]+nums[left]+nums[right];
                        minDistance = currentDistance;
                    }
                    if(nums[i]+nums[left]+nums[right] > target){
                        right--;
                    } else if (nums[i]+nums[left]+nums[right] < target){
                        left++;
                    } else {
                        return target;
                    }
                }
            }
        }
        return sum;
    }

    private int distance(int a, int b){
        return a>b? (a-b): (b-a);
    }
}
