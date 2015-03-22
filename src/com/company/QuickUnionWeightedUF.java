package com.company;

public class QuickUnionWeightedUF
{
    private int[] id, treesize;

    QuickUnionWeightedUF(int N)
    {
        id = new int[N];
        treesize = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            treesize[i] = 1;
        }
    }

    private int root (int p)    // Simple one-pass variant (grandparent)
    {
        while ( id[p] != p )
        {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected (int p, int q)
    {
        return root(p) == root(q);
    }

    public void union (int p, int q)
    {
        int p_root = root(p), q_root = root(q);
        if ( p_root == q_root )
            return;
        if ( treesize[p_root] < treesize[q_root] )
        {
            id[p_root] = q_root;
            treesize[q_root] += treesize[p_root];
        }
        else
        {
            id[q_root] = p_root;
            treesize[p_root] += treesize[q_root];
        }
    }

    public void printIDs()
    {
        System.out.print("id[]:");
        for (int element : id)
            System.out.print(" " + element);
        System.out.println();
        System.out.print("treeaize[]:");
        for (int element : treesize)
            System.out.print(" " + element);
        System.out.println();
    }

    public static void main (String[] args)
    {
        System.out.println("Quick Union Weighted demo from Coursera");
        QuickUnionWeightedUF QuickUnionWeighted1 = new QuickUnionWeightedUF(10);
        QuickUnionWeighted1.printIDs();
        QuickUnionWeighted1.union(4, 3);
        QuickUnionWeighted1.union(3, 8);
        QuickUnionWeighted1.union(6, 5);
        QuickUnionWeighted1.union(9, 4);
        QuickUnionWeighted1.union(2, 1);
        QuickUnionWeighted1.printIDs();
        QuickUnionWeighted1.union(5, 0);
        QuickUnionWeighted1.union(7, 2);
        QuickUnionWeighted1.union(6, 1);
        QuickUnionWeighted1.union(7, 3);
        QuickUnionWeighted1.printIDs();
    }
}

