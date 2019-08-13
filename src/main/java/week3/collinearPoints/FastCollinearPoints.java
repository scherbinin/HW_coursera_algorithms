package week3.collinearPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] lineSegments = new LineSegment[0];
    private int size = 0;

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
        if (isValidateInputData(points)) {
            Point[] internalCollection = new Point[points.length];
            System.arraycopy(points, 0, internalCollection, 0, points.length);
            calculateLineSegments(internalCollection);
        }
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private boolean isValidateInputData(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i] == null || points[j] == null)
                    throw new IllegalArgumentException();

                if (points[i].compareTo(points[j]) == 0)
                    throw new IllegalArgumentException();
            }
        }

        return points.length >= 4;
    }

    private void calculateLineSegments(Point[] points) {
        LineSegment[] lines = new LineSegment[points.length];

        // Apply sort by distance
        Arrays.sort(points);

        for (int startPointIndex = 0; startPointIndex < points.length; startPointIndex++) {
            Point startPoint = points[startPointIndex];
            Point[] sortedBySlope = MergeSort.sort(points, startPointIndex);
            int pointAmountOnSameSlope = 0;
            Point maxPoint = startPoint;
            Point minPoint = startPoint;

            for (int j = 1; j < sortedBySlope.length; j++) {
                if (startPoint.slopeOrder().compare(sortedBySlope[j - 1], sortedBySlope[j]) == 0) {

                    // We should find the min point also, to prevent overlapped lines: we need only the biggest and smallest points
                    // If start point is bigger that min point - that means that point already laying on the segment
                    if (minPoint.compareTo(sortedBySlope[j]) > 0)
                        minPoint = sortedBySlope[j];

                    // Uncomment it in case first Point in 'sortedBySlope' is the highest point.
                    if (minPoint.compareTo(sortedBySlope[j - 1]) > 0)
                        minPoint = sortedBySlope[j - 1];

                    // Because we sorted points by size, current startPoint will be the smallest and first point of the line, we need only higher points
                    if (startPoint.compareTo(sortedBySlope[j]) < 0) {
                        // Need memorize the highest point
                        if (maxPoint.compareTo(sortedBySlope[j]) < 0)
                            maxPoint = sortedBySlope[j];

                        // Uncomment it in case first Point in 'sortedBySlope' is the highest point.
                        if (maxPoint.compareTo(sortedBySlope[j - 1]) < 0)
                            maxPoint = sortedBySlope[j - 1];

                        pointAmountOnSameSlope++;
                    }
                }
            }

            // We don't count 'startPoint', so we need just 3 next point on slope
            if (pointAmountOnSameSlope >= 2) {
                if (startPoint.equals(minPoint))
                    lines[size++] = new LineSegment(minPoint, maxPoint);
            }
        }

        // Because we can't predict the amount of line segments initially, we use the draft array
        lineSegments = new LineSegment[size];
        System.arraycopy(lines, 0, lineSegments, 0, size);
    }

    // the number of line segments
    public int numberOfSegments() {
        return size;
    }

    // the line segments
    public LineSegment[] segments() {
        return lineSegments;
    }

    private static class MergeSort {
        static Point[] sort(Point[] arr, int startPointIndex) {
            Point[] sortedPoints = new Point[arr.length - 1];
            int ind = 0;

            // Make future sorted list by coping but missing the start point
            for (int k = 0; k < arr.length; k++) {
                if (startPointIndex == k) continue;
                sortedPoints[ind++] = arr[k];
            }

            sort(sortedPoints, 0, sortedPoints.length, arr[startPointIndex]);

            return sortedPoints;
        }

        static void sort(Point[] arr, int left, int right, Point start) {
            int mid = (right - left) / 2 + left;

            if (right - left > 1) {
                sort(arr, left, mid, start);
                sort(arr, mid, right, start);
            }

            merge(arr, left, right, mid, start);
        }

        static void merge(Point[] arr, int left, int right, int mid, Point start) {
            int leftIndex = left;
            int midIndex = mid;

            Point[] aux = new Point[right - left];

            for (int i = 0; i < right - left; i++) {
                if (midIndex == right) {
                    aux[i] = arr[leftIndex++];
                } else if (leftIndex == mid) {
                    aux[i] = arr[midIndex++];
                } else if (start.slopeOrder().compare(arr[leftIndex], arr[midIndex]) < 0) {
                    aux[i] = arr[leftIndex++];
                } else {
                    aux[i] = arr[midIndex++];
                }
            }

            System.arraycopy(aux, 0, arr, left, aux.length);
        }
    }
}
