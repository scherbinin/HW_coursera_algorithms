package week3.collinearPoints;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Created by scher on 12.08.2019.
 */
public class LineSegment {
   private Point p;
   private Point q;

   // constructs the line segment between points p and q
   public LineSegment(Point p, Point q) {
      this.p = p;
      this.q = q;
   }

   // draws this line segment
   public void draw() {
      StdDraw.setPenColor(Color.RED);
      p.drawTo(q);
   }

   // string representation
   public String toString() {
      return String.format("LineSegment: %s - %s", p.toString(), q.toString());
   }
}
