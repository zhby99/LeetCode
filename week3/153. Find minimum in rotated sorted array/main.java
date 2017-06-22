public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = (right+left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else if(nums[mid] < nums[left] && nums[mid] < nums[right]){
                right = mid;
            } else{
                return nums[left];
            }
        }
        return nums[left];
    }
}
