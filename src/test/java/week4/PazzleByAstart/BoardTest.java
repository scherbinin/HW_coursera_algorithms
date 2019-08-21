package week4.PazzleByAstart;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by scher on 21.08.2019.
 */
public class BoardTest {
    @Test
    public void testHammingDistance_whenWrong7Tiles_ExpectedDistanceEquals7() {
        int[][] tiles = {{1, 2, 3, 8},
                {5, 6, 7, 4},
                {10, 9, 11, 12},
                {0, 13, 14, 15}};

        Board board = new Board(tiles);

        System.out.println(board.toString());

        assertEquals(7, board.hamming());
    }

    @Test
    public void testHammingDistance_whenWrong1Tiles_ExpectedDistanceEquals1() {
        int[][] tiles = {{1, 2, 3},
                {4, 5, 6},
                {7, 0, 8}};

        Board board = new Board(tiles);

        System.out.println(board.toString());

        assertEquals(1, board.hamming());
    }

    @Test
    public void testManhattanDistance_whenWrong5Tiles_ExpectedDistanceEquals5() {
        int[][] tiles = {{1, 2, 3},
                {4, 5, 0},
                {6, 7, 8}};

        //3 permutations for '6' and 1 permutation for '7' and one for '8' in total 5 permutations
        Board board = new Board(tiles);

        System.out.println(board.toString());

        assertEquals(5, board.manhattan());
    }

    @Test
    public void testForNeighbors_printoutAllOnConsole() {
        int[][] tiles = {{1, 2, 3},
                {4, 0, 6},
                {7, 8, 5}};

        Board board = new Board(tiles);

        for (Board neighbors : board.neighbors()) {
            System.out.println("---------");
            System.out.println(neighbors);
        }

    }

    @Test
    public void testTwin_printoutAllOnConsole() {
        int[][] tiles = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}};

        Board board = new Board(tiles);

        System.out.println("--- original ---");
        System.out.println(board);

        System.out.println("--- twinned ---");
        System.out.println(board.twin());
    }

    @Test
    public void testIsGoal_WhereWrongBoard() {
        int[][] tiles = {{1, 2, 3},
                {4, 5, 6},
                {7, 0, 8}};

        Board board = new Board(tiles);

        assertFalse(board.isGoal());
    }

    @Test
    public void testIsGoal_WhereCorrectBoard() {
        int[][] tiles = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}};

        Board board = new Board(tiles);

        assertTrue(board.isGoal());
    }
}
