package week5;

import org.junit.Before;
import org.junit.Test;
import week3.collinearPoints.Point;
import week5.intersectionsOfGeometricPrimitives.KdTree;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;
import week5.intersectionsOfGeometricPrimitives.primitives.RectHV;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by scher on 09.09.2019.
 */
public class KdTreeTest {
    private KdTree kdTree;
    private Point2D point1 = new Point2D(11,9);
    private Point2D point2 = new Point2D(18,7);
    private Point2D point3 = new Point2D(6,10);
    private Point2D point4 = new Point2D(4,1);
    private Point2D point5 = new Point2D(2,7);
    private Point2D point6 = new Point2D(9,15);
    private Point2D point7 = new Point2D(13,6);
    private Point2D point8 = new Point2D(23,18);
    private Point2D point9 = new Point2D(21,16);
    private Point2D point10 = new Point2D(16,3);

    private RectHV rect1 = new RectHV(4, 13,10, 18);
    private RectHV rect2 = new RectHV(14, 10,20, 14);
    private RectHV rect3 = new RectHV(19, 6,22, 9);
    private RectHV rect4 = new RectHV(11.5, 5,19, 9);

    @Before
    public void setup() {
        kdTree = new KdTree();

        kdTree.insert(point1);
        kdTree.insert(point2);
        kdTree.insert(point3);
        kdTree.insert(point4);
        kdTree.insert(point5);
        kdTree.insert(point6);
        kdTree.insert(point7);
        kdTree.insert(point8);
        kdTree.insert(point9);
        kdTree.insert(point10);
    }

    @Test
    public void executeContains_when10PointInserting_expectedCorrectBehaviour() {
        Point2D extraPoint = new Point2D(10,10);

        assertFalse(kdTree.contains(extraPoint));
        assertTrue(kdTree.contains(point1));
        assertTrue(kdTree.contains(point2));
        assertTrue(kdTree.contains(point3));
        assertTrue(kdTree.contains(point4));
        assertTrue(kdTree.contains(point5));
        assertTrue(kdTree.contains(point6));
        assertTrue(kdTree.contains(point7));
        assertTrue(kdTree.contains(point8));
        assertTrue(kdTree.contains(point9));
        assertTrue(kdTree.contains(point10));
    }

    @Test
    public void executeRange_when10PointInsertingAndChecking3Rects_expectedCorrectBehaviour() {
        Iterable<Point2D> actual = kdTree.range(rect3);
        assertEquals(0,convertToList(actual).size());

        actual = kdTree.range(rect2);
        assertEquals(0,convertToList(actual).size());

        actual = kdTree.range(rect1);
        assertArrayEquals(new Point2D[]{point6},convertToList(actual).toArray());

        actual = kdTree.range(rect4);
        assertArrayEquals(new Point2D[]{point7, point2},convertToList(actual).toArray());
    }

    @Test
    public void executeNearest_when10PointInsertingAndChecking2Points_expectedCorrectBehaviour() {
        Point2D pointClosestToPoint10 = new Point2D(16,5);
        Point2D pointClosestToPoint5 = new Point2D(4,8);
        Point2D pointClosestToPoint3 = new Point2D(4,9);

        Point2D actual = kdTree.nearest(pointClosestToPoint5);
        assertEquals(point5, actual);

        actual = kdTree.nearest(pointClosestToPoint3);
        assertEquals(point3, actual);

        actual = kdTree.nearest(pointClosestToPoint10);
        assertEquals(point10, actual);
    }

    private List<Point2D> convertToList(Iterable<Point2D> actual) {
        List<Point2D> actualList = new ArrayList<>();

        for (Point2D point2D : actual) {
            actualList.add(point2D);
        }

        return actualList;
    }
}
