// THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
// A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Yuritzy Ramos

// As given, this is already a fast enough solution to the "Array Max"
// challenge on hackerrank.  However, we want a solution using less
// space, and that does not rely on java.util.* data structures.
// See the Canvas "code3" assignment for a more precise statement
// of constraints and advice.

// Reminders:
//   1. remember to put your name in the SPCA comment above.
//   2. read the Canvas "code3" assignment for more details.
//   3. remember to submit your link and paragraph on Canvas.

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.StringTokenizer;

public class ArrayMax
{
    // We will maintain a min-PQ of Entry objects.
    // Each Entry (i,v) represents an assignment "A[i]=v".\
    
    static class Entry implements Comparable<Entry> {
        int i, v;
        Entry(int i, int v) { this.i=i; this.v=v; }
        // We negate the "v" comparison, so that PriorityQueue (a MinPQ)
        // returns the Entry with the maximum v.  We break ties with i,
        // so we can find the leftmost appearance of the maximum.
        public int compareTo(Entry that) {
            int dif = -(this.v - that.v);
            if (dif==0) // break ties with the index i
                dif = this.i - that.i;
            return dif;
        }
    }

    public static void main(String[] args) throws IOException
    {
        // Buffered output (for faster printing)
        PrintWriter out = new PrintWriter(System.out);
        // Buffered input (we also avoid java.util.Scanner)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()),
            N = Integer.parseInt(st.nextToken());
        //Initialize an indexed min-pq of size M that accepts of type Entry
        IndexMinPQ<Entry> pq = new IndexMinPQ<Entry>(M);
        
        //Initialize values of the min-pq to zero so that it contains entries when 
        //reading input stream
        for(int h = 0; h<M; ++h){
            pq.insert(h, new Entry(h,0));
        }
        
         // Loop through the N assignment lines
         for (int n=0; n<N; ++n) {
         // read the line, parse i and v
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()),
                v = Integer.parseInt(st.nextToken());
        //Initialize a variable j (index of the largest value in keys[])
             int j = 0; 
        //Change the value associated with index i in keys[]
             pq.changeKey(i,new Entry(i,v));
        //Assign the index of the maximum value to j
             j = pq.minIndex();
        //Print out the index stored in j
             out.println(j);  
         }
        out.close();
     }
    // If you need helper classes, you can make them static inner classes
    // like this example class Foo:
  static class IndexMinPQ<Key extends Comparable<Key>>{
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;      // keys[i] = priority of i

    /**
     * Initializes an empty indexed priority queue with indices between {@code 0}
     * and {@code maxN - 1}.
     * @param  maxN the keys on this priority queue are index from {@code 0}
     *         {@code maxN - 1}
     * @throws IllegalArgumentException if {@code maxN < 0}
     */
    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];                   // make this of length maxN??
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    /**
     * Is {@code i} an index on this priority queue?
     *
     * @param  i an index
     * @return {@code true} if {@code i} is an index on this priority queue;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     */
    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }
    /**
     * Associates key with index {@code i}.
     *
     * @param  i an index
     * @param  key the key to associate with index {@code i}
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if there already is an item associated
     *         with index {@code i}
     */
    public void insert(int i, Key key) {
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    /**
     * Returns an index associated with a minimum key.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int minIndex() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * Change the key associated with index {@code i} to the specified value.
     *
     * @param  i the index of the key to change
     * @param  key change the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws NoSuchElementException no key is associated with index {@code i}
     */
    public void changeKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

   
    // throw an IllegalArgumentException if i is an invalid index
    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }

   /***************************************************************************
    * General helper functions.
    ***************************************************************************/
    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


   /***************************************************************************
    * Heap helper functions.
    ***************************************************************************/
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    }
}