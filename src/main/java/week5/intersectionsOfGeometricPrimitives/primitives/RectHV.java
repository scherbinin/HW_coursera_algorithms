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
        this.ymax = ymin;

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
        boolean belongXInterval = false;
        boolean belongYInterval = false;
        // we are checking that at least on vertex of the income Rect is belonging to current
        // When we must check opposite conditions: current Rect can belong to the income one

        if (biggerOrEquals(that.xmin, this.xmin) && lessOrEquals(that.xmin, this.xmax) ||
                biggerOrEquals(that.xmax, this.xmin) && lessOrEquals(that.xmax, this.xmax))
            belongXInterval = true;

        if (biggerOrEquals(that.ymin, this.ymin) && lessOrEquals(that.ymin, this.ymax) ||
                biggerOrEquals(that.ymax, this.ymin) && lessOrEquals(that.ymax, this.ymax))
            belongYInterval = true;

        return (belongXInterval && belongYInterval) || that.intersects(this);
    }

    // Euclidean distance from point p to closest point in rectangle
    public double distanceTo(Point2D p) {
//        boolean belongXInterval = false;
//        boolean belongYInterval = false;
//
//        if (biggerOrEquals(p.x(), xmin) && lessOrEquals(p.x(), xmax))
//            belongXInterval = true;
//
//        if (biggerOrEquals(p.y(), ymin) && lessOrEquals(p.y(), ymax))
//            belongYInterval = true;
//
//        if (belongXInterval && belongYInterval) {
//            return 0;
//        } else if (belongXInterval) {
//            return Math.abs(ymin - p.y());
//        } else if (belongYInterval) {
//            return Math.abs(xmin - p.x());
//        } else {
//            //4 cases: one of the vertex will the closest one
//
//
//        }

        double middleX = (xmax + xmin) / 2;
        double middleY = (ymax + ymin) / 2;

        if (lessOrEquals(middleX, p.x())) {
            // two left points
            if (lessOrEquals(middleY, p.x()))
                return p.distanceTo(new Point2D(xmin, ymin));
            else
                return p.distanceTo(new Point2D(xmin, ymax));
        } else {
            // two right points
            if (lessOrEquals(middleY, p.x()))
                return p.distanceTo(new Point2D(xmax, ymin));
            else
                return p.distanceTo(new Point2D(xmax, ymax));
        }
    }

    // square of Euclidean distance from point p to closest point in rectangle
    public double distanceSquaredTo(Point2D p) {
        double middleX = (xmax + xmin) / 2;
        double middleY = (ymax + ymin) / 2;

        if (lessOrEquals(middleX, p.x())) {
            // two left points
            if (lessOrEquals(middleY, p.x()))
                return p.distanceSquaredTo(new Point2D(xmin, ymin));
            else
                return p.distanceSquaredTo(new Point2D(xmin, ymax));
        } else {
            // two right points
            if (lessOrEquals(middleY, p.x()))
                return p.distanceSquaredTo(new Point2D(xmax, ymin));
            else
                return p.distanceSquaredTo(new Point2D(xmax, ymax));
        }
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
        StdDraw.filledRectangle(xmin, ymin, (xmax-xmin)/2, (ymax - ymin)/2);
    }

    // string representation
    public String toString() {
        return String.format("Point2D: Xmin=%f | Xmax=%f | Ymin=%f | Ymax=%f", xmin, xmax, ymin, ymax);
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
