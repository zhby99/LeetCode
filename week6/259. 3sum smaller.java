public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            int currentTarget = target - nums[i];
            while(left < right){
                if(nums[left] + nums[right] < currentTarget){
                    res += right - left;
                    left++;
                } else{
                    right--;
                }
            }
        }
        return res;
    }
}
