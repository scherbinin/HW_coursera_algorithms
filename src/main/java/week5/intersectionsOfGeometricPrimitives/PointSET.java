package week5.intersectionsOfGeometricPrimitives;

import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

// Brute-force implementation. Write a mutable data type PointSET.java
// that represents a set of points in the unit square. Implement the following API by using a red–black BST
public class PointSET {
    // construct an empty set of points
    public PointSET() {
        throw new UnsupportedOperationException();
    }

    // is the set empty?
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    // number of points in the set
    public int size() {
        throw new UnsupportedOperationException();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        throw new UnsupportedOperationException();
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        throw new UnsupportedOperationException();
    }

    // draw all points to standard draw
    public void draw() {
        throw new UnsupportedOperationException();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        throw new UnsupportedOperationException();
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        throw new UnsupportedOperationException();
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
    }
}