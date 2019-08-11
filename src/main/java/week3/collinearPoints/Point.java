package week3.collinearPoints;

import java.util.Comparator;

/**
 * Created by scher on 12.08.2019.
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // draws this point
    public void draw() {

    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {

    }

    // string representation
    public String toString() {

    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        if(this.y == that.y) {
            if(this.x < that.x)
                return -1;
            else if(this.x == that.x)
                return 0;
            else return 1;
        } else if (this.y < that.y) {
            return -1;
        }

        return 1;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {

    }

    // compare two points by slopes they make with this point
    public Comparator<Point> slopeOrder() {

    }
}