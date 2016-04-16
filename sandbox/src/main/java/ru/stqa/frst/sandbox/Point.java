package ru.stqa.frst.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
}

  public static void main (String[] args){
    Point p1 = new Point(3,1);

    Point p2 = new Point(5,2);


    System.out.println("Расстояние между точками (3,1) & (5,2) =" + Point.distance(p1,p2));
  }

  public  static double distance (Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }
}


