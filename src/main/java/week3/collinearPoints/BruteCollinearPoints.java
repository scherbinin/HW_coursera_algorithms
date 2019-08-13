package week3.collinearPoints;

import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] lineSegments = new LineSegment[0];

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (isValidateInputData(points)) {
            Point[] internalCollection = new Point[points.length];
            System.arraycopy(points, 0, internalCollection, 0, points.length);
            calculateLineSegments(internalCollection);
        }
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
        Arrays.sort(points);
        LineSegment[] segments = new LineSegment[points.length];
        int index = 0;

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    if (points[i].slopeOrder().compare(points[j], points[k]) == 0) {
                        for (int n = points.length - 1; n > k; n--) {
                            double slope = points[i].slopeTo(points[n]);

                            // if 4 point are lying on one straight
                            if (points[i].slopeOrder().compare(points[j], points[n]) == 0) {
                                segments[index++] = new LineSegment(points[i], points[n]);
                            }
                        }
                    }
                }
            }
        }

        this.lineSegments = new LineSegment[index];

        System.arraycopy(segments, 0, this.lineSegments, 0, index);
    }

    // the number of line segments
    public int numberOfSegments() {
        return lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return lineSegments;
    }
}
