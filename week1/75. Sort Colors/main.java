public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length -1 ;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[index] == 0){
                nums[index] = nums[left];
                nums[left++] = 0;
                index++;
            }
            else if(nums[index] == 2){
                nums[index] = nums[right];
                nums[right--] = 2;
            }
            else{
                index++;
            }
        }
    }
}
