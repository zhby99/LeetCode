public class LFUCache {

    HashMap<Integer, Node> cache;
    HashMap<Integer, Node> headLists;
    HashMap<Integer, Node> tailLists;
    HashMap<Integer, Integer> listSize;
    int currentFreq;
    int size;
    int capacity;

    public class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public int freq;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
            this.freq = 0;
        }
    }


    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.headLists = new HashMap<>();
        this.tailLists = new HashMap<>();
        this.listSize = new HashMap<>();
        constructListMap(1);
        this.currentFreq = 1;
        this.capacity = capacity;
    }

    private Node constructListMap(int freq){
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        headLists.put(freq, head);
        tailLists.put(freq, tail);
        listSize.put(freq, 0);
        return head;
    }

    private void insertToHead(Node node, Node head){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeFromList(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeLF(){
        Node tail = tailLists.get(currentFreq);
        int left = listSize.get(currentFreq) - 1;
        cache.remove(tail.prev.key);
        removeFromList(tail.prev);
        listSize.put(currentFreq, left);
        while(left == 0 && this.capacity != 1){
            currentFreq++;
            left =listSize.get(currentFreq);
        }
        size--;
    }

    private void changeList(Node node){
        listSize.put(node.freq, listSize.get(node.freq) - 1);
        if(listSize.get(node.freq) == 0 && this.currentFreq == node.freq){
            this.currentFreq++;
        }
        node.freq++;
        removeFromList(node);
        Node head = headLists.get(node.freq);
        if(head == null){
            head = constructListMap(node.freq);
        }
        insertToHead(node, head);
        listSize.put(node.freq, listSize.get(node.freq) + 1);
    }

    public int get(int key) {
        Node node= cache.get(key);
        if(node == null){
            return -1;
        } else{
            changeList(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(this.capacity == 0){
            return;
        }
        Node node = cache.get(key);
        if(node == null){
            size++;
            if(size > capacity){
                removeLF();
            }
            node = new Node(key, value);
            node.freq = 1;
            Node head = headLists.get(1);
            insertToHead(node, head);
            listSize.put(1, listSize.get(1) + 1);
            this.currentFreq = 1;
        } else{
            node.value = value;
            changeList(node);
        }
        cache.put(key,node);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
