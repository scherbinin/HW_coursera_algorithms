package week4.PazzleByAstart;

import edu.princeton.cs.algs4.LinkedStack;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Objects;

public class Solver {
    private SearchNode solution;
    private boolean initialBoardNotSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (Objects.isNull(initial))
            throw new IllegalArgumentException();

        MinPQ<SearchNode> workStructure1 = new MinPQ<>();
        MinPQ<SearchNode> workStructure2 = new MinPQ<>();

        SearchNode currSearchNode1 = new SearchNode(initial, null);
        SearchNode currSearchNode2 = new SearchNode(initial.twin(), null);

        workStructure1.insert(currSearchNode1);
        workStructure2.insert(currSearchNode2);

        // We have to start solving operation for both init boards (initial and twined) simultaneously
        while (!currSearchNode1.getBoard().isGoal()) {
            // Case where the twinned board was solved, but initial don't have solution
            if (currSearchNode2.getBoard().isGoal()) {
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

    private SearchNode addNeighborsToHeapAndFindTheMinNode(MinPQ<SearchNode> workStructure, SearchNode currSearchNode) {
        for (Board neighbor : currSearchNode.getBoard().neighbors()) {
            // Optimization: exclude the duplicates: prev board and one of the neighbors of current board
            if (Objects.nonNull(currSearchNode.getPrevSearchNode())) {
                if (!neighbor.equals(currSearchNode.getPrevSearchNode().getBoard()))
                    workStructure.insert(new SearchNode(neighbor, currSearchNode));
            } else {
                workStructure.insert(new SearchNode(neighbor, currSearchNode));
            }
        }

        return workStructure.delMin();
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return !initialBoardNotSolvable;
    }

    // min number of moves to solve initial board
    public int moves() {
        if(!isSolvable())
            return -1;

        return solution.getMovesNumber();
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        if(!isSolvable())
            return null;

        LinkedStack<Board> solutionSequence = new LinkedStack<>();
        SearchNode currSearchNode = solution;

        while (Objects.nonNull(currSearchNode)) {
            solutionSequence.push(currSearchNode.getBoard());
            currSearchNode = currSearchNode.getPrevSearchNode();
        }

        return solutionSequence;
    }

    private static class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final SearchNode prevSearchNode;
        private final int priority;
        private int movesNumber;

        SearchNode(Board board, SearchNode prevSearchNode) {
            this.board = board;
            this.prevSearchNode = prevSearchNode;

            if (prevSearchNode != null)
                movesNumber = prevSearchNode.getMovesNumber() + 1;

            priority = board.manhattan() + movesNumber;
        }

        Board getBoard() {
            return board;
        }

        SearchNode getPrevSearchNode() {
            return prevSearchNode;
        }

        int getMovesNumber() {
            return movesNumber;
        }

        int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(SearchNode second) {
            return Integer.compare(this.priority, second.getPriority());
        }
    }

}
