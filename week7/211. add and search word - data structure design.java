public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            TrieNode next = node.children.get(c);
            if(next == null){
                next = new TrieNode();
                node.children.put(c, next);
                node = next;
            } else{
                node = next;
            }
        }
        node.value = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(0, word, root);
    }

    private boolean helper(int start, String word, TrieNode node){
        if(start == word.length()){
            return !node.value.equals("");
        }
        String tmpWord = word.substring(start);
        char currentChar = word.charAt(start);
        if(currentChar != '.'){
            TrieNode nextNode = node.children.get(currentChar);
            if(nextNode == null){
                return false;
            } else{
                return helper(start + 1, word, nextNode);
            }
        }
        for(char c : node.children.keySet()){
            TrieNode nextNode = node.children.get(c);
            if(helper(start + 1, word, nextNode)){
                return true;
            }
        }
        return false;
    }

    class TrieNode{
        public HashMap<Character, TrieNode> children;
        public String value;

        TrieNode(){
            children = new HashMap<>();
            value = "";
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
