package ru.stqa.frst.sandbox;

import org.testng.annotations.Test;

/**
 * Created by user on 16.04.2016.
 */
public class SquareTests {
  @Test
  public void testArea(){
    Square s = new Square(5);
  assert s.area() == 25;
}
}