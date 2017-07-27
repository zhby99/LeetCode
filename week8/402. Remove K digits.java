public class Solution {
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        for (int i = 0 ; i < num.length(); i++){
            while(top > 0 && k > 0 && num.charAt(i) < stk[top - 1]){
                top--;
                k--;
            }
            stk[top++] = num.charAt(i);
        }

        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);

    }
}
