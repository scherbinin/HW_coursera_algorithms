package week1.unions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by scher on 30.07.2019.
 */
public class PercolationTaskTest {
    Percolation percolation;

    @Before
    public void setup() {
        percolation = new Percolation(5);
    }

    @Test
    public void testPercolation_whenOpenDirectVerticalLine_expectedPercolated() {
        percolation.open(1,1);
        percolation.open(2,1);
        percolation.open(3,1);
        percolation.open(4,1);
        percolation.open(5,1);

        boolean actual = percolation.percolates();
        boolean expected = true;

        assertEquals(actual, expected);
    }

    @Test
    public void testPercolation_whenOpenInclinedLine_expectedPercolated() {
        percolation.open(1,1);
        percolation.open(1,2);
        percolation.open(2,2);
        percolation.open(2,3);
        percolation.open(3,3);
        percolation.open(3,4);
        percolation.open(4,4);
        percolation.open(4,5);
        percolation.open(5,5);

//        percolation.print();

        boolean actual = percolation.percolates();
        boolean expected = true;

        assertEquals(actual, expected);
    }

    @Test
    public void testPercolation_whenOpenZigZagLine_expectedPercolated() {
        percolation.open(1,1);
        percolation.open(2,1);
        percolation.open(3,1);
        percolation.open(3,2);
        percolation.open(3,3);
        percolation.open(3,4);
        percolation.open(3,5);
        percolation.open(4,5);
        percolation.open(5,5);

        //percolation.print();

        boolean actual = percolation.percolates();
        boolean expected = true;

        assertEquals(actual, expected);
    }

    @Test
    public void testPercolation_whenOpenInternalSquaresUntilItPercolate_expectedPercolated() {
        percolation.open(4, 5);
        percolation.open(3, 1);
        percolation.open(4, 4);
        percolation.open(5, 3);
        percolation.open(2, 4);
        percolation.open(2, 4);
        percolation.open(1, 4);
        percolation.open(5, 4);
        percolation.open(3, 1);
        percolation.open(3, 2);
        percolation.open(5, 4);
        percolation.open(2, 2);
        percolation.open(2, 5);
        percolation.open(4, 5);
        percolation.open(3, 4);

        percolation.print();

        boolean actual = percolation.percolates();
        boolean expected = true;

        assertEquals(actual, expected);
    }

    @Test
    public void testBackWash() {
        percolation.open(5, 4);
        percolation.isFull(5,4);

        percolation.open(4, 4);
        percolation.isFull(5,4);

        percolation.print();

        boolean actual = percolation.percolates();
        boolean expected = false;

        assertEquals(actual, expected);
    }
}
