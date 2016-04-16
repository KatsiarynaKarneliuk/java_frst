package ru.stqa.frst.sandbox;

import org.testng.annotations.Test;

/**
 * Created by user on 16.04.2016.
 */
public class PointTests {
@Test
  public void testDistance() {
    Point p1 = new Point(3, 1); // construct first point
    Point p2 = new Point(5, 2); // construct second point
    assert
            Math.abs( // get math module
                    Point.distance(p1, p2) - 2.236 // compare
            ) < 0.1; // if eps less than 0.1
  }
}