public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int index = 1;
        int cur = 1;
        int size = nums.length;
        while(index<=size-1){
            int offset = 0;
            while(nums[cur] == nums[index-1]){
                cur++;
                offset++;
                if(cur == size){
                    break;
                }
            }
            if(offset!=0){
                for(int j=index; j<size-offset;j++){
                    nums[j] = nums[j+offset];
                }
                size -= offset;
            }
            index++;
            cur = index;
        }
        return size;
    }
}
