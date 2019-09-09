package week5.intersectionsOfGeometricPrimitives;

import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

import java.util.*;

// Brute-force implementation. Write a mutable data type PointSET.java
// that represents a set of points in the unit square. Implement the following API by using a red–black BST
public class PointSET {
    private Set<Point2D> pointsContainer;

    // construct an empty set of points
    public PointSET() {
        pointsContainer = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return pointsContainer.isEmpty();
    }

    // number of points in the set
    public int size() {
        return pointsContainer.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if(Objects.isNull(p))
            throw new IllegalArgumentException();

        pointsContainer.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if(Objects.isNull(p))
            throw new IllegalArgumentException();

        return pointsContainer.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        throw new UnsupportedOperationException();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if(Objects.isNull(rect))
            throw new IllegalArgumentException();

        List<Point2D> inRect = new LinkedList<>();

        for (Point2D point2D : pointsContainer) {
            if(rect.contains(point2D))
                inRect.add(point2D);
        }

        return inRect;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if(Objects.isNull(p))
            throw new IllegalArgumentException();

        double minDist = Double.MAX_VALUE;
        Point2D nearestPoint = null;

        for (Point2D point2D : pointsContainer) {
            double currDist = p.distanceTo(point2D);

            if(minDist > currDist) {
                minDist = currDist;
                nearestPoint = point2D;
            }
        }

        return nearestPoint;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
    }
}
