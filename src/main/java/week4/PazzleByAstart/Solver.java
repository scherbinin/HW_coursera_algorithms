package week4.PazzleByAstart;

import edu.princeton.cs.algs4.LinkedStack;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Objects;

public class Solver {
    private Board.SearchNode solution;
    private int movesAmount = 0;
    private boolean initialBoardNotSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (Objects.isNull(initial))
            throw new IllegalArgumentException();

        MinPQ<Board.SearchNode> workStructure1 = new MinPQ<>();
        MinPQ<Board.SearchNode> workStructure2 = new MinPQ<>();

        Board.SearchNode currSearchNode1 = new Board.SearchNode(initial, null, movesAmount);
        Board.SearchNode currSearchNode2 = new Board.SearchNode(initial.twin(), null, movesAmount);

        //We have to start solving operation for both init boards (initial and twined) simultaneously
        while (!currSearchNode1.getBoard().isGoal()) {
            //Case where the twinned board was solved, but initial don't have solution
            if (!currSearchNode2.getBoard().isGoal()) {
                initialBoardNotSolvable = true;
                break;
            }

            currSearchNode1 = addNeighborsToHeapAndFindTheMinNode(workStructure1, currSearchNode1);
            currSearchNode2 = addNeighborsToHeapAndFindTheMinNode(workStructure2, currSearchNode2);
        }

        if (initialBoardNotSolvable)
            solution = currSearchNode2;
        else
            solution = currSearchNode1;
    }

    private Board.SearchNode addNeighborsToHeapAndFindTheMinNode(MinPQ<Board.SearchNode> workStructure, Board.SearchNode currSearchNode) {
        //Increase the moves amount
        movesAmount++;

        for (Board neighbor : currSearchNode.getBoard().neighbors()) {
            //Optimization: exclude the duplicates: prev board and one of the neighbors of current board
            if (Objects.nonNull(currSearchNode.getPrevSearchNode()) &&
                    !neighbor.equals(currSearchNode.getPrevSearchNode().getBoard()))
                workStructure.insert(new Board.SearchNode(neighbor, currSearchNode, movesAmount));
        }

        return workStructure.delMin();
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return initialBoardNotSolvable;
    }

    // min number of moves to solve initial board
    public int moves() {
        return movesAmount;
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        LinkedStack<Board> solutionSequence = new LinkedStack<>();
        Board.SearchNode currSearchNode = solution;

        while (Objects.nonNull(currSearchNode)) {
            solutionSequence.push(currSearchNode.getBoard());
            currSearchNode = currSearchNode.getPrevSearchNode();
        }

        return solutionSequence;
    }

    // test client (see below)
    public static void main(String[] args) {

    }

}
