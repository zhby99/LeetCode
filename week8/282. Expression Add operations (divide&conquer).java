public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> candidate = new ArrayList<>();
        if(num.length() == 0){
            return candidate;
        }
        helper(num, target, candidate, "", 0, 0, 0);
        return candidate;
    }

    private void helper(String num, int target, List<String> candidate, String path, int pos, long total, long last){
        if(pos == num.length()){
            if(total == target){
                candidate.add(path);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(num, target, candidate, "" + cur, i + 1, cur, cur);
            } else{
                helper(num, target, candidate, path + "+" + cur, i + 1, total + cur, cur);
                helper(num, target, candidate, path + "-" + cur, i + 1, total - cur, -cur);
                helper(num, target, candidate, path + "*" + cur, i + 1, total - last + last * cur, last * cur);
            }
        }
    }
}
