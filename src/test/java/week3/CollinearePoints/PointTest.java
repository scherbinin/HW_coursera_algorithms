package week3.CollinearePoints;

import org.junit.Test;
import week3.collinearPoints.Point;

/**
 * Created by scher on 14.08.2019.
 */
public class PointTest {
    @Test
    public void test() {
        Point point1 = new Point(1,4);
        Point point2 = new Point(9,0);
        Point point3 = new Point(1,4);

        double slopePQ = point1.slopeTo(point2);
        double slopePR = point1.slopeTo(point3);
        double compare = point1.slopeOrder().compare(point2, point3);

    }
}
