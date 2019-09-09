package week5.intersectionsOfGeometricPrimitives.primitives;

import edu.princeton.cs.algs4.StdDraw;
import java.util.Objects;

public class Point2D implements Comparable<Point2D> {
    private double x;
    private double y;

    // construct the point (x, y)
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // x-coordinate
    public double x() {
        return x;
    }

    // y-coordinate
    public double y() {
        return y;
    }

    // Euclidean distance between two points
    public double distanceTo(Point2D that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    // square of Euclidean distance between two points
    public double distanceSquaredTo(Point2D that) {
        return Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2);
    }

    // for use in an ordered symbol table
    public int compareTo(Point2D that) {
        if (Objects.isNull(that))
            throw new IllegalArgumentException();

        if (this.y < that.y) {
            return -1;
        } else if (this.y > that.y) {
            return 1;
        } else if (this.x < that.x) {
            return -1;
        } else {
            return this.x > that.x ? 1 : 0;
        }
    }

    // does this point equal that object?
    public boolean equals(Object that) {
        if (this==that)
            return true;

        if(Objects.isNull(that))
            return false;

        if (!that.getClass().equals(Point2D.class))
            return false;

        return this.compareTo((Point2D) that) == 0;
    }

    // draw to standard draw
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, 3);
    }

    // string representation
    public String toString() {
        return String.format("Point2D: x=%f | y=%f", x, y);
    }
}
