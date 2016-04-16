package ru.stqa.frst.sandbox;

/**
 * Created by user on 15.04.2016.
 */

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
}
  Point p1 = new Point(3,1);

  Point p2 = new Point(5,2);


  public static void main (String[] args){
    System.out.println("Расстояние между точками" + p1.xy +" и " + p2.xy + " = " + p.distance();
  }

  public  double distance () {
    return Math.sqrt(Math.pow(this.p1.x - this.p2.x, 2) + Math.pow(this.p1.y - this.p2.y, 2));
  }
}