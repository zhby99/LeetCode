public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int n = heights.length;
        Info[][] dp = new Info[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = new Info(heights[i], heights[i]);
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n - i; j++){
                dp[j][j + i] = getFromLastLevel(dp, j, j + i);
                //System.out.println("====="+j+" , "+(j+i)+"=====");
                //System.out.println(dp[j][j+i].area);
            }
        }
        return dp[0][n - 1].area;
    }

    private Info getFromLastLevel(Info[][] dp, int start, int end){
        Info left = dp[start][end - 1];
        Info right = dp[start + 1][end];
        int area1 = Math.min(left.low, right.low) * (end - start + 1);
        if(area1 > left.area){
            if(area1 > right.area){
                return new Info(area1, Math.min(left.low, right.low));
            }
            else{
                return new Info(right.area, Math.min(left.low, right.low));
            }
        }
        else if(area1 < left.area){
            if(left.area > right.area){
                return new Info(left.area, Math.min(left.low, right.low));
            }
            else if(left.area < right.area){
                return new Info(right.area, Math.min(left.low, right.low));
            }
            else{
                if(left.low > right.low){
                    return new Info(left.area, Math.min(left.low, right.low));
                } else{
                    return new Info(right.area, Math.min(left.low, right.low));
                }
            }
        }
        else{
            if(right.area > left.area){
                return new Info(right.area, Math.min(left.low, right.low));
            } else if(left.area > right.area){
                return new Info(left.area, Math.min(left.low, right.low));
            } else{
                if(left.low > right.low){
                    return new Info(left.area, Math.min(left.low, right.low));
                } else{
                    return new Info(right.area, Math.min(left.low, right.low));
                }
            }
        }
    }

    class Info{
        public int area;
        public int low;

        public Info(int a, int l){
            this.area = a;
            this.low = l;
        }
    }
}
