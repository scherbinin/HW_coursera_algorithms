package week3.collinearPoints;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by scher on 12.08.2019.
 */
public class BruteCollinearPoints {

   private LineSegment[] lineSegments;

   // finds all line segments containing 4 points
   public BruteCollinearPoints(Point[] points) {
      if (points.length < 4)
         return;

      calculateLineSegments(points);
   }

   private void calculateLineSegments(Point[] points) {
      double[] lines = new double[points.length];//Index - start point, value - end point
      Arrays.sort(points);
      LineSegment[] lineSegments = new LineSegment[points.length];
      int index = 0;

      for (int i = 0; i < lines.length; i++)
         lines[i] = -1;

      for (int i = 0; i < points.length - 3; i++) {
         for (int j = i + 1; j < points.length - 2; j++) {
            for (int k = j + 1; k < points.length - 1; k++) {
               if (points[i].slopeOrder().compare(points[j], points[k]) == 0) {
                  for (int l = points.length - 1; l > k; l--) {
                     double slope = points[i].slopeTo(points[l]);

                     //if 4 point are lying on one straight
                     if (points[i].slopeOrder().compare(points[j], points[l]) == 0) {

                        //Check if defined line already contained all some of those points.
                        //Need just to define exactly one line which doesn't contains or intersects with some different line with the same slope
                        if(Double.compare(lines[l], slope)!=0 &&
                                Double.compare(lines[j], slope) != 0 &&
                                Double.compare(lines[j], slope) != 0 &&
                                Double.compare(lines[i], slope) != 0) {
                           lines[i] = slope;//save slope for the first point of line, to except all further point on that line
                           lines[l] = slope;
                           lines[j] = slope;
                           lines[k] = slope;
                           lineSegments[index++] = new LineSegment(points[i], points[l]);
                        }
                     }
                  }
               }
            }
         }
      }

      this.lineSegments = new LineSegment[index];

      for (int i = 0; i < index; i++)
         this.lineSegments[i] = lineSegments[i];
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
