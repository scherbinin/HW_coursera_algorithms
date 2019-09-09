package week5.intersectionsOfGeometricPrimitives;

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
        throw new UnsupportedOperationException();
    }

    // number of points in the set
    public int size() {
        throw new UnsupportedOperationException();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if(Objects.isNull(p))
            throw new IllegalArgumentException();

        Node newNode = new Node(p);
        Node currNode = root;
        Boolean isVertical = true;


        while(Boolean.TRUE) {
            if(isVertical){
                if(currNode.value.x() > p.x()) {
                    currNode = currNode.left;
                } else {
                    currNode = currNode.right;
                }
            } else {
                if(currNode.value.y() > p.y()) {
                    currNode = currNode.left;
                } else {
                    currNode = currNode.right;
                }
            }

            isVertical=!isVertical;
        }


    }

    private void insert(Node node) {

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
        throw new UnsupportedOperationException();
    }

    class Node{
        private Point2D value;
        private Node left;
        private Node right;

        public Node(Point2D value) {
            this.value = value;
        }

        public Point2D getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
