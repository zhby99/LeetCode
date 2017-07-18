public class ZigzagIterator {

    Queue<Iterator<Integer>> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if(!v1.isEmpty()){
            q.offer(v1.iterator());
        }
        if(!v2.isEmpty()){
            q.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> current = q.poll();
        int nextNum = current.next();
        if(current.hasNext()){
            q.offer(current);
        }
        return nextNum;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
