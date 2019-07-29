package week1.unions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by scher on 29.07.2019.
 */
public class UnionEngine {
    private int[] nodes;
    private int[] sz;

    public UnionEngine(int size) {
        nodes = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            nodes[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int node1, int node2) {
        //Define the smallest tree and connect to it the second one
        int treeSize1 = sz[node1];
        int treeSize2 = sz[node2];
        int root2 = getRoot(node2);
        int root1 = getRoot(node1);

        if (sz[root1] < sz[root2]) {
            nodes[root1] = root2;
            sz[root1] = treeSize1 + treeSize2;
        } else {
            nodes[root2] = root1;
            sz[root1] = treeSize1 + treeSize2;
        }
    }

    public boolean isConnected(int node1, int node2) {
        return getRoot(node1) == getRoot(node2);
    }

    public int find(int index) {
        if (index < 0 || index > nodes.length - 1)
            throw new ArrayStoreException("Is not a part of the any union");

        int root = getRoot(index);
        int max = nodes[index];

        for (int i = nodes.length - 1; i > 0; i--) {
            if (root == getRoot(i) && max < i)
                max = i;
        }

        return max;
    }

    public Map<Integer, LinkedList<Integer>> getUnions() {
        Map<Integer, LinkedList<Integer>> sites = new HashMap<>();

        for (int i = 0; i < nodes.length; i++) {
            int root = getRoot(i);

            if (sites.containsKey(root))
                sites.get(root).add(i);
            else {
                LinkedList<Integer> elements = new LinkedList<>();
                elements.add(i);
                sites.put(root, elements);
            }
        }

        return sites;
    }

    private int getRoot(int node) {
        while (nodes[node] != node)
            node = nodes[node];

        return node;
    }
}
