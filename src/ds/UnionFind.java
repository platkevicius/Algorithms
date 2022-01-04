package ds;

import java.util.Arrays;

public class UnionFind {

    private int size;

    private int[] sz;

    private int[] id;

    public UnionFind(int size) {
        if (size <= 0)
            throw  new IllegalArgumentException("The size cannot be less than 0!");

        this.size = size;

        sz = new int[size];
        id = new int[size];

        Arrays.fill(sz, 1);

        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    // finds root node and performs path compression
    public int find(int q) {

        // finds root node
        int root = q;
        while (root != id[root])
            root = id[root];

        // performs path compression
        while (q != id[root]) {
            int next = id[q];
            id[q] = root;
            q = next;
        }

        return root;
    }

    public boolean isConnected(int q, int p) {
        return find(q) == find(p);
    }

    public void unify(int q, int p) {
        if (isConnected(q, p)) return;

        int rootQ = find(q);
        int rootP = find(p);

        if (sz[rootP] < sz[rootQ]) {
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;
            sz[rootP] = 0;
        } else {
            sz[rootP] += sz[rootQ];
            id[rootQ] = rootP;
            sz[rootQ] = 0;
        }
    }

}
