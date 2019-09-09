package week5.intersectionsOfGeometricPrimitives;

import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.princeton.cs.algs4.Transaction;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

import java.util.Objects;

public class KdTree {
    private Node root;

    // construct an empty set of points
    public KdTree() {

    }

    // is the set empty?
    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    // number of points in the set
    public int size() {
        throw new UnsupportedOperationException();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (Objects.isNull(p))
            throw new IllegalArgumentException();

        root = insert(true, root, new Node(p));
    }

    private Node insert(boolean isVertical, Node current, Node newNode) {
        if (Objects.isNull(current))
            return newNode;

        if (isVertical) {
            if (current.value.x() > newNode.value.x()) {
                current.left = insert(!isVertical, current.left, newNode);
            } else {
                current.right = insert(!isVertical, current.right, newNode);
            }
        } else {
            if (current.value.y() > newNode.value.y()) {
                current.left = insert(!isVertical, current.left, newNode);
            } else {
                current.right = insert(!isVertical, current.right, newNode);
            }
        }

        return current;
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (Objects.isNull(p))
            throw new IllegalArgumentException();

        if (Objects.isNull(root))
            return false;

        Node current = root;
        boolean isVertical = true;

        while (Objects.nonNull(current)) {
            double newVal = isVertical ? p.x() : p.y();
            double val = isVertical ? current.value.x() : current.value.y();

            if (current.value.equals(p)) {
                return true;
            } else if (val > newVal) {
                current = current.left;
            } else {
                current = current.right;
            }

            isVertical = !isVertical;
        }

        return false;
    }

    // draw all points to standard draw
    public void draw() {
        throw new UnsupportedOperationException();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (Objects.isNull(rect))
            throw new IllegalArgumentException();

        if (Objects.isNull(root))
            return false;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        throw new UnsupportedOperationException();
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    private class Node {
        private Point2D value;
        private Node left;
        private Node right;

        Node(Point2D value) {
            this.value = value;
        }
    }
}
