public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<Num> pq = new PriorityQueue<Num>();
        for(int i = 0; i < primes.length; i++){
            pq.offer(new Num(primes[i], 1, primes[i]));
        }
        int prev = 1;
        int i = 1;
        while(i < n){
            Num cur = pq.poll();
            if(cur.val == prev){
                pq.offer(new Num(cur.prime * ugly[cur.pos], cur.pos + 1, cur.prime));
                continue;
            }
            prev = cur.val;
            ugly[i++] = cur.val;
            pq.offer(new Num(cur.prime * ugly[cur.pos], cur.pos + 1, cur.prime));
        }
        return ugly[n-1];
    }

    class Num implements Comparable<Num>{
        int val;
        int pos;
        int prime;
        public Num(int val, int pos, int prime){
            this.val = val;
            this.pos = pos;
            this.prime = prime;
        }

        @Override
        public int compareTo(Num that){
            return (this.val - that.val);
        }
    }
}
