package week3.collinearPoints;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, 3);
    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
        draw();
        that.draw();

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return String.format("point: (%d, %d)", x, y);
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y == that.y) {
            return Double.compare(this.x, that.x);
        } else if (this.y < that.y) {
            return -1;
        }

        return 1;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        double deltaX = that.x - this.x;
        double deltaY = that.y - this.y;

        if (deltaX == 0 && deltaY == 0)
            return Double.NEGATIVE_INFINITY;

        if (deltaX == 0)
            return Double.POSITIVE_INFINITY;

        double slope = deltaY / deltaX;

        // Because -0.0 not equal 0.0. But they are should be equal
        if (slope == 0)
            return 0;

        return slope;
    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {
        return (o1, o2) -> {
            double slope1 = slopeTo(o1);
            double slope2 = slopeTo(o2);

            if (o1 == o2)
                return 0;

            return Double.compare(slope1, slope2);
        };
    }
}