package week4.PazzleByAstart;

import edu.princeton.cs.algs4.MinPQ;
import java.util.Objects;

public class Board implements Comparable<Board> {
    private int[][] tiles;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException("The input array is null");

        this.tiles = tiles;
    }

    // string representation of this board
    @Override
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
                int expectedNumber = i * tiles.length + j +1;

                //Last position at n^2 is placed by Zero title, we don't need analyze it
                if (expectedNumber > tiles.length * tiles.length - 1)
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
            for (int j = 0; j < tiles[i].length; j++) {
                int expectedNumber = i * tiles.length + j +1;
                if (expectedNumber != tiles[i][j] && tiles[i][j] != 0) {
                    int vertDist = (tiles[i][j] - 1) / tiles.length;
                    int horizDist = (tiles[i][j] - 1) % (tiles.length);

                    distance += Math.abs(i - vertDist);
                    distance += Math.abs(j - horizDist);
                }
            }
        }

        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0 && tiles[tiles.length - 1][tiles.length - 1] == 0;
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
        MinPQ<Board> res = new MinPQ<>();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                }
            }
        }

        if (zeroX == -1)
            throw new IllegalArgumentException("The empty tile not found");

        Board upNeighbor = getUpNeighborBoard(zeroX, zeroY);
        Board downNeighbor = getDownNeighborBoard(zeroX, zeroY);
        Board leftNeighbor = getLeftNeighborBoard(zeroX, zeroY);
        Board rightNeighbor = getRightNeighborBoard(zeroX, zeroY);

        if (Objects.nonNull(upNeighbor))
            res.insert(upNeighbor);
        if (Objects.nonNull(downNeighbor))
            res.insert(downNeighbor);
        if (Objects.nonNull(leftNeighbor))
            res.insert(leftNeighbor);
        if (Objects.nonNull(rightNeighbor))
            res.insert(rightNeighbor);

        return res;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int firstTileX = 0;
        int firstTileY =0;
        int secondTileX = 1;
        int secondTileY = 0;

        int[][] tilesArrCopy = new int[tiles.length][tiles.length];

        for (int i = 0; i < tiles.length; i++) {
            System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
        }

        while(tilesArrCopy[firstTileX][firstTileY] == 0)
            firstTileY++;
        while(tilesArrCopy[secondTileX][secondTileY] == 0)
            secondTileY++;

        int temp = tilesArrCopy[firstTileX][firstTileY];
        tilesArrCopy[firstTileX][firstTileY] = tilesArrCopy[secondTileX][secondTileY];
        tilesArrCopy[secondTileX][secondTileY] = temp;

        return new Board(tilesArrCopy);
    }


    // unit testing (not graded)
    public static void main(String[] args) {

    }

    private Board getUpNeighborBoard(int zeroX, int zeroY) {
        if (zeroX > 0) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i < tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX - 1][zeroY];
            tilesArrCopy[zeroX - 1][zeroY] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    private Board getDownNeighborBoard(int zeroX, int zeroY) {
        if (zeroX < tiles.length - 1) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i < tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX + 1][zeroY];
            tilesArrCopy[zeroX + 1][zeroY] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    private Board getLeftNeighborBoard(int zeroX, int zeroY) {
        if (zeroY > 0) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i < tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX][zeroY - 1];
            tilesArrCopy[zeroX][zeroY - 1] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    private Board getRightNeighborBoard(int zeroX, int zeroY) {
        if (zeroY < tiles.length - 1) {
            int[][] tilesArrCopy = new int[tiles.length][tiles.length];

            for (int i = 0; i < tiles.length; i++) {
                System.arraycopy(tiles[i], 0, tilesArrCopy[i], 0, tiles.length);
            }

            tilesArrCopy[zeroX][zeroY] = tilesArrCopy[zeroX][zeroY + 1];
            tilesArrCopy[zeroX][zeroY + 1] = 0;

            return new Board(tilesArrCopy);
        }

        return null;
    }

    @Override
    public int compareTo(Board o) {
        if(manhattan() - o.manhattan() < 0)
            return -1;
        else if(manhattan() == o.manhattan())
            return 0;
        else
            return 1;
    }
}