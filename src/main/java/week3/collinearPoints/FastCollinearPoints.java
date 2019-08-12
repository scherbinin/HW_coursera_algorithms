package week3.collinearPoints;

/**
 * Created by scher on 12.08.2019.
 */
public class FastCollinearPoints {
    private LineSegment[] lineSegments;
    private int size = 0;

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
        lineSegments = new LineSegment[points.length];

        if (points.length < 4)
            return;

        calculateLineSegments(points);
    }

    private void calculateLineSegments(Point[] points) {
        for (int startPointIndex = 0; startPointIndex < points.length; startPointIndex++) {
            Point startPoint = points[startPointIndex];
            Point[] sortedBySlope = MergeSort.sort(points, startPointIndex);
            int indexOfLastCollinearPoint = 0;

            for (int j = 1; j < sortedBySlope.length; j++) {
                if(startPoint.slopeOrder().compare(sortedBySlope[j-1], sortedBySlope[j]) == 0) {
                    indexOfLastCollinearPoint = j;
                }
            }

            if(indexOfLastCollinearPoint >= 4)
                lineSegments[size++] = new LineSegment(startPoint, sortedBySlope[indexOfLastCollinearPoint]);
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return size;
    }

    // the line segments
    public LineSegment[] segments() {
        return lineSegments;
    }

    static class MergeSort {
        static Point[] sort(Point[] arr, int startPointIndex) {
            Point[] sortedPoints = new Point[arr.length-1];
            int ind = 0;

            //Make future sorted list by coping but missing the start point
            for (int k = 0; k < arr.length; k++){
                if(startPointIndex == k) continue;
                sortedPoints[ind++] = arr[k];
            }

            sort(arr, 0, sortedPoints.length, arr[startPointIndex]);

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

        static void merge(Point[] arr, Integer left, Integer right, int mid, Point start) {
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

            for (int i = 0; i < aux.length; i++) {
                arr[left + i] = aux[i];
            }
        }
    }
}
