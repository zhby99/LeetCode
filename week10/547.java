

public class Solution {
    public int findCircleNum(int[][] M) {
        if(M.length == 0){
            return 0;
        }
        int n = M.length;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1 && i!=j){
                    int x = uFind(nums, i);
                    int y = uFind(nums, j);
                    if(x != y){
                        nums[x] = y;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i <n ; i++){
            if(nums[i] == -1){
                res++;
            }
        }
        return res;
    }

    private int uFind(int[] nums, int i){
        if(nums[i] == -1){
            return i;
        }
        return uFind(nums, nums[i]);
    }
}
