
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == next) {
                if(nums[i] == Integer.MAX_VALUE){
                    return res;
                }
                next++;
            } else if(nums[i]>next){
                res.add(getRange(next, nums[i] - 1));
                if(nums[i] == Integer.MAX_VALUE){
                    return res;
                }
                next = nums[i] + 1;
            }
        }
        if (next <= upper) res.add(getRange(next, upper));
        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.valueOf(n1)+"->"+String.valueOf(n2);
    }
}
