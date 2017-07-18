public class StringIterator {
    int index;
    char currentChar;
    int left;
    String data;
    public StringIterator(String compressedString) {
        index = 0;
        left = 0;
        data = compressedString;
    }

    public char next() {
        if(index == data.length() && left == 0){
            return ' ';
        }
        if(left == 0){
            currentChar = data.charAt(index++);
            while (index < data.length() && Character.isDigit(data.charAt(index))) {
                left = left * 10 + data.charAt(index) - '0';
                index++;
            }
            left--;
            return currentChar;
        } else{
            left--;
            return currentChar;
        }
    }

    public boolean hasNext() {
        return index < data.length() || left != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
