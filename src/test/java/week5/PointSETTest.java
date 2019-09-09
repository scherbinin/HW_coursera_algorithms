package week5;

import org.junit.Test;
import week3.collinearPoints.Point;
import week5.intersectionsOfGeometricPrimitives.PointSET;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class PointSETTest {
    @Test
    public void executeRange_when2PointsAreIntoAnd2OutsideRectangle_expectedRightBehavior(){
        PointSET testedContainer = new PointSET();
        Point2D point1 = new Point2D(0,0);
        Point2D point2 = new Point2D(2,2);
        Point2D point3 = new Point2D(2,3);
        Point2D point4 = new Point2D(4,4);


        testedContainer.insert(point1);
        testedContainer.insert(point2);
        testedContainer.insert(point3);
        testedContainer.insert(point4);

        Iterable<Point2D> actual = testedContainer.range(new RectHV(1, 1, 3, 3));
        List<Point2D> expected = Arrays.asList(point2, point3);

        assertArrayEquals(expected.toArray(), convertToList(actual).toArray());
    }

    @Test
    public void executeNearest_when5DifferentPointsExist_expectedRightBehavior(){
        PointSET testedContainer = new PointSET();
        Point2D point1 = new Point2D(0,0);
        Point2D point2 = new Point2D(2,2);
        Point2D point3 = new Point2D(2,3);
        Point2D point4 = new Point2D(4,4);
        Point2D point5 = new Point2D(10,5);


        testedContainer.insert(point1);
        testedContainer.insert(point2);
        testedContainer.insert(point3);
        testedContainer.insert(point4);
        testedContainer.insert(point5);

        Point2D actual = testedContainer.nearest(new Point2D(7, 5));
        Point2D expected = point5;

        assertEquals(expected, actual);
    }

    private List<Point2D> convertToList(Iterable<Point2D> actual) {
        List<Point2D> actualList = new ArrayList<>();

        for (Point2D point2D : actual) {
            actualList.add(point2D);
        }

        return actualList;
    }
}
