package week5.intersectionsOfGeometricPrimitives;

import week3.collinearPoints.Point;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

import java.util.LinkedList;
import java.util.List;
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
                current.left = insert(false, current.left, newNode);
            } else {
                current.right = insert(false, current.right, newNode);
            }
        } else {
            if (current.value.y() > newNode.value.y()) {
                current.left = insert(true, current.left, newNode);
            } else {
                current.right = insert(true, current.right, newNode);
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

        List<Point2D> result = new LinkedList<>();

        if (!isEmpty())
            intersectionSearch(root, true, rect, result);

        return result;
    }

    private void intersectionSearch(Node current, boolean isVertical, RectHV rect, List<Point2D> result) {
        if (Objects.isNull(current))
            return;

        int direction = current.compareTo(rect, isVertical);

        if (direction == -1) {
            intersectionSearch(current.left, !isVertical, rect, result);
        } else if (direction == 1) {
            intersectionSearch(current.right, !isVertical, rect, result);
        } else {
            // have intersection with rectangle: we have to check both children
            intersectionSearch(current.left, !isVertical, rect, result);
            intersectionSearch(current.right, !isVertical, rect, result);

            if (rect.contains(current.value))
                result.add(current.value);
        }
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (Objects.isNull(p))
            throw new IllegalArgumentException();

        if (isEmpty())
            return null;

        return searchNearest(root, p.distanceSquaredTo(root.value), p, root.value, true);
    }

    private Point2D searchNearest(Node current, double minDist, Point2D p, Point2D minPoint, boolean isVertical) {
        if (Objects.isNull(current))
            return minPoint;

        double newVal = isVertical ? p.x() : p.y();
        double val = isVertical ? current.value.x() : current.value.y();
        double dist = p.distanceSquaredTo(current.value);
        double minDistFromPointToLine = Math.pow((val - newVal), 2);

        if (minDist > dist) {
            minDist = dist;
            minPoint = current.value;
        }

        if (val > newVal) {
            // go to left first
            minPoint = searchNearest(current.left, minDist, p, minPoint, !isVertical);

            dist = p.distanceSquaredTo(minPoint);
            minDist = minDist < dist ? minDist : dist;

            // Check distance to line separator, if it's closer than minDist then possibly exists point from another side of line
            if (minDist > minDistFromPointToLine)
                minPoint = searchNearest(current.right, minDist, p, minPoint, !isVertical);

        } else {
            // go to right first
            minPoint = searchNearest(current.right, minDist, p, minPoint, !isVertical);

            dist = p.distanceSquaredTo(minPoint);
            minDist = minDist < dist ? minDist : dist;

            if (minDist > minDistFromPointToLine)
                minPoint = searchNearest(current.left, minDist, p, minPoint, !isVertical);

        }

        return minPoint;
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

        // -1: go left: current node has bigger value X|Y than according value from Rect: Rect are laying on left|above
        // 1: go right: current node has smaller value X|Y than according value from Rect: Rect are laying on right|lower
        // 0: intersection: current node has the equal value X|Y than according value from Rect: vertical|horizontal line intersects Rect
        int compareTo(RectHV rect, boolean isVertical) {
            double val = isVertical ? value.x() : value.y();
            double newValMin = isVertical ? rect.xmin() : rect.ymin();
            double newValMax = isVertical ? rect.xmax() : rect.ymax();


            if (newValMax < val)
                return -1;
            else if (newValMin > val)
                return 1;
            else
                return 0;
        }
    }
}
