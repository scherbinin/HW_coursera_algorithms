package week5.intersectionsOfGeometricPrimitives;

import org.junit.Test;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class RectHVTest {
    @Test
    public void executeContains_whenSomePointsIntoSomeOnBorderSomeOut() {
        Point2D intoPoint = new Point2D(2,1);
        Point2D outPoint = new Point2D(3,3);
        Point2D borderPoint = new Point2D(1,0);

        RectHV rect = new RectHV(1,-1, 3, 2);

        assertTrue(rect.contains(intoPoint));
        assertFalse(rect.contains(outPoint));
        assertTrue(rect.contains(borderPoint));
    }

    @Test
    public void executeIntersects_whenSomeRectLayingIntoSomeIntersectsSomeNotInteresects() {
        RectHV intersectRect = new RectHV(4,1, 6, 3);
        RectHV intoRect = new RectHV(2,0, 3, 1);
        RectHV notIntersectRect = new RectHV(7,1, 8,10);

        RectHV rect = new RectHV(1,-1, 5, 2);

        assertTrue(rect.intersects(intoRect));
        assertFalse(rect.intersects(notIntersectRect));
        assertTrue(rect.intersects(intersectRect));
    }

    @Test
    public void executeDistanceTo_whenPointIntoAndPointOutside() {
        Double expectedForInternalPointDistance = 0.0;
        Double expectedExternalPoint1Distance = 1.0;
        Double expectedExternalPoint2Distance = 2.0;
        Double expectedSquaredExternalPoint2Distance = 4.0;

        Point2D intoPoint = new Point2D(2,1);
        Point2D externalPoint1 = new Point2D(3,3);
        Point2D externalPoint2 = new Point2D(5,1);

        RectHV rect = new RectHV(1,-1, 3, 2);

        assertEquals(expectedForInternalPointDistance, rect.distanceTo(intoPoint));
        assertEquals(expectedExternalPoint1Distance, rect.distanceTo(externalPoint1));
        assertEquals(expectedExternalPoint2Distance, rect.distanceTo(externalPoint2));
        assertEquals(expectedSquaredExternalPoint2Distance, rect.distanceSquaredTo(externalPoint2));
    }
}
