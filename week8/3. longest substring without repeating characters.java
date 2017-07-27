public class Solution {
    Map<Character, Integer> map;
    public int lengthOfLongestSubstring(String s) {
        int last = 0;
        int res = 0;
        int current = 0;
        map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                current++;
            } else{
                if(map.get(s.charAt(i)) < last){
                    map.put(s.charAt(i), i);
                    current++;
                    continue;
                }
                last = map.get(s.charAt(i));
                map.put(s.charAt(i), i);
                if(current > res){
                    res = current;
                }
                current = i - last;
            }
        }
        if(current > res){
            res = current;
        }
        return res;
    }
}
