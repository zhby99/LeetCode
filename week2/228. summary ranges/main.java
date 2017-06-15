public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<String>();
        }
        if(nums.length == 1){
            return new ArrayList<String>(Arrays.asList(String.valueOf(nums[0])));
        }
        List<String> res = new ArrayList<String>();
        int left = nums[0];
        int right = -1;
        for(int i = 1; i < nums.length; i++){
            System.out.println(nums[i]);
            if(nums[i] != nums[i-1] + 1){
                right = nums[i-1];
                if(right == left){
                    res.add(String.valueOf(left));
                } else{
                    res.add(String.valueOf(left)+"->"+String.valueOf(right));
                }
                left = nums[i];
            }
        }
        right = nums[nums.length-1];
        if(right == left){
            res.add(String.valueOf(left));
        } else{
            res.add(String.valueOf(left)+"->"+String.valueOf(right));
        }
        return res;
    }
}
