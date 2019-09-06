package week5.intersectionsOfGeometricPrimitives.primitives;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Objects;

public class RectHV {
    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;

    // construct the rectangle [xmin, xmax] x [ymin, ymax]
    // throw a java.lang.IllegalArgumentException if (xmin > xmax) or (ymin > ymax)
    public RectHV(double xmin, double ymin,
                  double xmax, double ymax) {
        this.xmax = xmax;
        this.xmin = xmin;
        this.ymax = ymax;
        this.ymin = ymin;

    }

    // minimum x-coordinate of rectangle
    public double xmin() {
        return xmin;
    }

    // minimum y-coordinate of rectangle
    public double ymin() {
        return ymin;
    }

    // maximum x-coordinate of rectangle
    public double xmax() {
        return xmax;
    }

    // maximum y-coordinate of rectangle
    public double ymax() {
        return ymax;
    }

    // does this rectangle contain the point p (either inside or on boundary)?
    public boolean contains(Point2D p) {
        boolean belongXInterval = false;
        boolean belongYInterval = false;

        if (biggerOrEquals(p.x(), xmin) && lessOrEquals(p.x(), xmax))
            belongXInterval = true;

        if (biggerOrEquals(p.y(), ymin) && lessOrEquals(p.y(), ymax))
            belongYInterval = true;

        return belongXInterval && belongYInterval;
    }

    // does this rectangle intersect that rectangle (at one or more points)?
    public boolean intersects(RectHV that) {
        return isIntersects(this, that) || isIntersects(that, this);
    }

    private boolean isIntersects(RectHV first, RectHV second) {
        boolean belongXInterval = false;
        boolean belongYInterval = false;
        // we are checking that at least on vertex of the income Rect is belonging to current
        // When we must check opposite conditions: current Rect can belong to the income one

        if (biggerOrEquals(second.xmin, first.xmin) && lessOrEquals(second.xmin, first.xmax) ||
                biggerOrEquals(second.xmax, first.xmin) && lessOrEquals(second.xmax, first.xmax))
            belongXInterval = true;

        if (biggerOrEquals(second.ymin, first.ymin) && lessOrEquals(second.ymin, first.ymax) ||
                biggerOrEquals(second.ymax, first.ymin) && lessOrEquals(second.ymax, first.ymax))
            belongYInterval = true;

        return belongXInterval && belongYInterval;
    }

    // Euclidean distance from point p to closest point in rectangle
    public double distanceTo(Point2D p) {
        return Math.sqrt(distanceSquaredTo(p));
    }

    // square of Euclidean distance from point p to closest point in rectangle
    public double distanceSquaredTo(Point2D p) {
        double deltaX = 0.0;
        double deltaY = 0.0;

        if(lessOrEquals(p.x(), this.xmin))
            deltaX = this.xmin - p.x();
        else if(biggerOrEquals(p.x(), this.xmax))
            deltaX = p.x() - this.xmax;

        if(lessOrEquals(p.y(), this.ymin))
            deltaY = this.ymin - p.x();
        else if(biggerOrEquals(p.y(), this.ymax))
            deltaY = p.x() - this.ymax;

        return Math.pow(deltaX,2) + Math.pow(deltaY,2);
    }

    // does this rectangle equal that object?
    public boolean equals(Object that) {
        if (Objects.equals(this, that))
            return true;

        if (!that.getClass().equals(RectHV.class))
            return false;

        return Double.compare(xmin, ((RectHV) that).xmin()) == 0 &&
                Double.compare(xmax, ((RectHV) that).xmax()) == 0 &&
                Double.compare(ymin, ((RectHV) that).ymin()) == 0 &&
                Double.compare(ymax, ((RectHV) that).ymax()) == 0;
    }

    // draw to standard draw
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(xmin, ymin, (xmax - xmin) / 2, (ymax - ymin) / 2);
    }

    // string representation
    public String toString() {
        return String.format("Point2D: Xmin=%f | Ymin=%f | Xmax=%f | Ymax=%f", xmin, ymin, xmax, ymax);
    }

    private boolean lessOrEquals(double o1, double o2) {
        return Double.compare(o1, o2) == -1 || equals(o1, o2);
    }

    private boolean biggerOrEquals(double o1, double o2) {
        return Double.compare(o1, o2) == 1 || equals(o1, o2);
    }

    private boolean equals(double o1, double o2) {
        return Double.compare(o1, o2) == 0;
    }
}
