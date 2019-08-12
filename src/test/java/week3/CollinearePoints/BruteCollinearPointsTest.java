package week3.CollinearePoints;

import org.junit.Test;
import week3.collinearPoints.BruteCollinearPoints;
import week3.collinearPoints.LineSegment;
import week3.collinearPoints.Point;

import static org.junit.Assert.assertEquals;

public class BruteCollinearPointsTest {
   private BruteCollinearPoints bruteCollinearPoints;

   @Test
   public void testCalculationOfCollinearPoints_whenExist3Lines_expectedOnlyOneLineSegment() {
      bruteCollinearPoints = new BruteCollinearPoints(get5CollinearPointAnd());
      int size = bruteCollinearPoints.numberOfSegments();
      LineSegment[] segments = bruteCollinearPoints.segments();

      assertEquals(3,size);
   }

   private Point[] get5CollinearPointAnd() {
      Point[] points = new Point[12];
      points[0] = new Point(1,1);
      points[1] = new Point(4,4);
      points[2] = new Point(2,2);
      points[3] = new Point(3,3);
      points[4] = new Point(5,5);
      points[5] = new Point(7,7);

      points[6] = new Point(2,7);
      points[7] = new Point(3,7);
      points[8] = new Point(4,7);

      points[9] = new Point(4,3);
      points[10] = new Point(5,3);
      points[11] = new Point(6,3);


      return points;
   }

}
