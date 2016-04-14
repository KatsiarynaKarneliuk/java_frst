package ru.stqa.first.sandbox;

/**
 * Created by user on 13.04.2016.
 */
public class Square {
  public double l;

  public Square(double l) {
    this.l = l;
  }

  public  double area() {
    return this.l * this.l;
  }
}