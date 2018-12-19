/***********************************************************************************************************************

 Idea behind this Approach:

 The algorithm proceeds in two stages.  First, we check the backbone nodes to make sure that they are connected.
 To do this, we map each node name to positive integer.  Then we use a union find data structure,
 which has been augmented to track how many sets are present.
 For each edge, we perform a find on the nodes, and union together the sets.

 Running Time for Phase 1: THETA(m alpha(m))

 The second phase of the algorithm collect all non-backbone nodes into a hash set,
 and all non-backbone nodes that are adjacent to a backbone node in another hash set.
 If these two sets are equal in size, the configuration is valid.

 Average case running time for phase 2: THETA(m)

 The total average case running time then is THETA(m alpha(m))

 **********************************************************************************************************************/

import java.io.*;
import java.util.*;

public class Solution {

    static HashMap<String,Integer> backbone = new HashMap<>(); // Map string names to integers in [1..N]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int v = 0; v < 2; v++) {
                String node = sc.next();
                if (!backbone.containsKey(node)) {
                    backbone.put(node, backbone.size()+1);
                }
                edges[i][v] = backbone.get(node);
            }
        }

        // Check to make sure that the backbone is connected
        DisjointSet uf = new DisjointSet(backbone.size());
        for (int i = 0; i < n; i++) {
            uf.makeSet(edges[i][0]);
            uf.makeSet(edges[i][1]);
            uf.union(edges[i][0],edges[i][1]);
        }
        if (uf.getSetCount() != 1) {
            System.out.println("invalid");
            return;
        }

        // Check remaining nodes to ensure that all are one hop from backbone
        HashSet<String> okExternalNodes = new HashSet<>(); // external nodes within one hop
        HashSet<String> allExternalNodes = new HashSet<>(); // all external nodes
        for (int i = 0; i < k; i++) {
            String n1 = sc.next();
            String n2 = sc.next();

            if (backbone.containsKey(n1)) {
                // n1 is in backbone, mark n2 as ok
                okExternalNodes.add(n2);
                allExternalNodes.add(n2);
            }
            else if (backbone.containsKey(n2)) {
                // n2 is in backbone, mark n1 as ok
                okExternalNodes.add(n1);
                allExternalNodes.add(n1);
            }
            else {
                // neither node is in the backbone
                allExternalNodes.add(n1);
                allExternalNodes.add(n2);
            }
        }

        if (allExternalNodes.size() == okExternalNodes.size()) {
            System.out.println("valid");
            return;
        }
        else {
            System.out.println("invalid");
            return;
        }
    }
}

/**
 * Note the disjoint set data structure has been augmented to track how many sets
 * have been created.
 *
 * @inv  sets[i] = 0, if i is not yet in a set
 * @inv  sets[i] = {parent of i}, if sets[i] > 0
 * @inv  sets[i] < 0 => i is the root of a tree, i.e. the set is called i
 * @inv  sets[i] = -{size of set i}, if sets[i] < 0
 */
class DisjointSet {
    int[] sets;
    int setCount = 0;

    public DisjointSet(int n) {
        sets = new int[n+1];
    }

    public void checkIndex(int x) {
        if (x < 1 || x >= sets.length) throw new IndexOutOfBoundsException();
    }

    public int getSetCount() { return setCount; }

    public void makeSet(int x) {
        checkIndex(x);
        if (sets[x] != 0)
            return;

        sets[x] = -1;
        setCount++;
    }

    public int find(int x) {
        checkIndex(x);
        if (sets[x] == 0)
            throw new IllegalArgumentException("Item " + x + " is not in a set");

        if (sets[x] < 0) return x;

        int retVal = find(sets[x]);

        sets[x] = retVal;

        return retVal;
    }

    public void union(int x, int y) {
        checkIndex(x);
        checkIndex(y);

        x = find(x);
        y = find(y);

        if (x == y) return;

        if (sets[x] > sets[y]) {
            sets[y] += sets[x];
            sets[x] = y;
        }
        else {
            sets[x] += sets[y];

            sets[y] = x;
        }
        setCount--;
    }
}
