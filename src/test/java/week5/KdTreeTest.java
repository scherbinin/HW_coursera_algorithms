package week5;

import org.junit.Before;
import org.junit.Test;
import week5.intersectionsOfGeometricPrimitives.KdTree;
import week5.intersectionsOfGeometricPrimitives.primitives.Point2D;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
