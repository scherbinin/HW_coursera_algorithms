package week4.PazzleByAstart;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Board {
    private int[][] tiles;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException("The input array is null");

        this.tiles = tiles;
    }

    // string representation of this board
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int[] tile : tiles) {
            for (int aTile : tile) {
                str.append(aTile);
                str.append(" ");
            }
            str.append("\n");
        }

        return str.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles in the wrong position
    public int hamming() {
        int distance = 0;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                int expectedNumber = i * tiles.length + j;

                //Last position at n^2 is placed by Zero title
                if (expectedNumber >= tiles.length * tiles.length - 2)
                    continue;

                if (expectedNumber != tiles[i][j])
                    distance++;
            }
        }

        return distance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length - 1; j++) {
                int expectedNumber = i * tiles.length + j;
                if (expectedNumber != tiles[i][j]) {
                    int vertDist = tiles[i][j] / i;
                    int horizDist = tiles[i][j] % i;

                    distance += Math.abs(i - vertDist);
                    distance += Math.abs(j - horizDist);
                }
            }
        }

        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0 && tiles[tiles.length - 1][tiles.length - 2] == 0;
    }

    // does this board equal y?
    @Override
    public boolean equals(Object y) {
        if (!(y instanceof int[][]))
            return false;

        int[][] newTiles = (int[][]) y;

        if (newTiles.length != tiles.length)
            return false;

        for (int i = 0; i < tiles.length; i++) {
            if (newTiles[i].length != tiles[i].length)
                return false;

            for (int j = 0; j < tiles[i].length; j++) {
                if (newTiles[i][j] != tiles[i][j])
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        int zeroX = -1;
        int zeroY = -1;
        LinkedList<Board> res = new LinkedList<>();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                }
            }
        }

        if(zeroX == -1)
            throw new IllegalArgumentException("The empty tile not found");

//        if(zeroX > 0)
//            Board up =

        return Arrays.asList();
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {

    }


    // unit testing (not graded)
    public static void main(String[] args) {

    }

    private Board getUpNeighborBoard(int zeroX, int zeroY) {
        if(zeroX > 0) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i< tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX - 1][zeroY];
            tilesArrCopy[zeroX - 1][zeroY] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    private Board getDownNeighborBoard(int zeroX, int zeroY) {
        if(zeroX < tiles.length - 1) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i< tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX + 1][zeroY];
            tilesArrCopy[zeroX + 1][zeroY] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    private Board getLeftNeighborBoard(int zeroX, int zeroY) {
        if(zeroY > 0) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i< tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX][zeroY - 1];
            tilesArrCopy[zeroX][zeroY - 1] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    private Board getRightNeighborBoard(int zeroX, int zeroY) {
        if(zeroY < tiles.length -1) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i< tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX][zeroY + 1];
            tilesArrCopy[zeroX][zeroY + 1] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }
}