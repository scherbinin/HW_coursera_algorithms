package week5.intersectionsOfGeometricPrimitives;

import org.junit.Test;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;

import static junit.framework.Assert.assertEquals;

public class Point2DTest {
    @Test
    public void euclideanDistanceTest() {
        final double expectedEucDist = 5.0;
        final double expectedSquredEucDist = 25.0;

        Point2D point1 = new Point2D(1,1);
        Point2D point2 = new Point2D(4,5);

        assertEquals(expectedEucDist, point1.distanceTo(point2));
        assertEquals(expectedSquredEucDist, point1.distanceSquaredTo(point2));
    }

}
