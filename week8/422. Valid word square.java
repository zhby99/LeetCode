public class Solution {
    public boolean validWordSquare(List<String> words) {
        int rowNum = words.size();
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < words.get(i).length(); j++){
                if(j >= rowNum){
                    return false;
                }
                if(words.get(j).length() < i + 1){
                    return false;
                }
                if(words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
