public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        while(left<=right){
            if(!charPair(num.charAt(left),num.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean charPair(char left, char right){
        if((left == '6' && right =='9')||(left =='0' && right =='0')||(left == '9' && right =='6')
            ||(left =='8' && right =='8')||(left =='1' && right == '1')){
                return true;
        }
        return false;
    }
}
