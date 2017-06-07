public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0;
        boolean flag = false;
        for(; i<nums.length; i++){
            if(nums[i]!=nums[j]&& flag){
                flag = false;
                j+=2;
                nums[j] = nums[i];
            }
            else if(nums[i]!=nums[j]&& !flag){
                j++;
                nums[j] = nums[i];
            }
            else if(nums[i]==nums[j]&&!flag){
                nums[j+1] = nums[i];
                flag = true;
            }
        }
        return flag? j+2:j+1;
    }
}
