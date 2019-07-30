package week1.unions;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class Percolation {
    private WeightedQuickUnionUF unionEngine;
    private int[] site;
    private final int SIZE;
    private final int N;//TODO i believe that is useless variable
    private final int TOP_SITE = 0;
    private final int BOTTOM_SITE = 1;
    private final int BLOCKED_SITE = -1;
    private int numberOfOpenSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        N = n;
        SIZE = n*n;

        //Zero index - is a virtual site for top row
        //SIZE+1 index - is virtual site for bottom row
        unionEngine = new WeightedQuickUnionUF(SIZE + 2);
        site = new int[SIZE + 2];//TODO fix it: don't nessecary to have 2 more elements
        site[TOP_SITE] = TOP_SITE;
        site[BOTTOM_SITE] = BOTTOM_SITE;

        for(int i=2; i<SIZE+2; i++)
            site[i] = BLOCKED_SITE;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateBoundaries(row, col);

        site[getIndexFlatArray(row, col)] = 0;
        numberOfOpenSites++;

        if(row == 1) { // The specific case where we should union TOP_SITE with any open cell from the first row
            //TODO: Actually it's a duplication, resolve it
            //TODO: probably we can simplify it: if we do union every time in correct order - the TOP_SITE will not change and will always equal ZERO
            unionEngine.union(getIndexFlatArray(row, col), TOP_SITE);
            site[TOP_SITE] = unionEngine.find(site[TOP_SITE]);
        }

        if(row == N) { // The specific case where we should union BOTTOM_SITE with any open cell from the last row
            //TODO: Actually it's a duplication, resolve it
            //TODO: probably we can simplify it: if we do union every time in correct order - the TOP_SITE will not change and will always equal ZERO
            unionEngine.union(BOTTOM_SITE, getIndexFlatArray(row, col));
            site[BOTTOM_SITE] = unionEngine.find(site[BOTTOM_SITE]);
        }

        //percolate it to all of its adjacent open sites.
        percolate(row-1, col, row, col);
        percolate(row+1, col, row, col);
        percolate(row, col-1, row, col);
        percolate(row, col+1, row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateBoundaries(row, col);

        return site[getIndexFlatArray(row, col)] != BLOCKED_SITE;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        //A full site is an open site that can be connected to an open site in the top row
        validateBoundaries(row, col);

        return unionEngine.connected(getIndexFlatArray(row,col), site[TOP_SITE]);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionEngine.connected(site[TOP_SITE], site[BOTTOM_SITE]);
    }

    // test client (optional)
    public static void main(String[] args) {

    }

    private void percolate(int row, int col, int actualRow, int actualCol) {
        if(inBoundaries(row, col) && isOpen(row, col)) {
//            int parent = unionEngine.find(getIndexFlatArray(actualRow, actualCol));

            //TODO: probably we can simplify it: if we do union every time in correct order - the TOP_SITE will not change and will always equal ZERO
            unionEngine.union(getIndexFlatArray(row, col), getIndexFlatArray(actualRow, actualCol));
            site[TOP_SITE] = unionEngine.find(site[TOP_SITE]);
        }
    }

    private int getIndexFlatArray(int row, int column) {
        return N*(row - 1) + column + 1;
    }

    private void validateBoundaries(int row, int col) {
        if(!inBoundaries(row, col))
            throw new IllegalArgumentException();
    }

    private boolean inBoundaries(int row, int col) {
        if(row < 1 || row > N || col < 1 || col > N)
            return false;

        return true;
    }
}
