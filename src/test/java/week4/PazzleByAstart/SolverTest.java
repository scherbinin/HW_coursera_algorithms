package week4.PazzleByAstart;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolverTest {
    @Test
    public void executeSolve_whenBoardNeedJust7Moves_expectTheSuccessAfter7Moves() {
        int[][] tilesArr = {{1, 0, 3},
                        {7, 2, 6},
                        {5, 4, 8}};

        Board board = new Board(tilesArr);
        Solver solver = new Solver(board);

        System.out.println("\nThe print out of the solution path: ");
        System.out.println("---- initial board ----");

        for (Board item : solver.solution()) {
            System.out.println(item);
            System.out.println("-------------");
        }

        System.out.println("Is solvable: " + solver.isSolvable());
        System.out.println("Number of moves: " + solver.moves());

        assertTrue(solver.isSolvable());
        assertEquals(solver.moves(), 7);
    }

    @Test
    public void executeSolve_whenBoardUnsolved_expectTheSuccessWithTwinTask() {
        int[][] tilesArr = {{1,2,3},
                {4,5,6},
                {8,7,0}};

        Board board = new Board(tilesArr);
        Solver solver = new Solver(board);

        System.out.println("\nThe print out of the solution path: ");
        System.out.println("---- initial board ----");

        for (Board item : solver.solution()) {
            System.out.println(item);
            System.out.println("-------------");
        }

        System.out.println("Is solvable: " + solver.isSolvable());
        System.out.println("Number of moves: " + solver.moves());

        assertFalse(solver.isSolvable());
    }
}
