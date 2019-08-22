package week4.PazzleByAstart;

import org.junit.Test;

public class SolverTest {
    @Test
    public void executeSolve_whenBoardNeedJust2Moves_expectThesuccesAfter2Moves() {
//        int[][] tilesArr = {{0,1,3},
//                {7,2,6},
//                {5,4,8}};

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
    }
}
