package ru.stqa.frst.sandbox;


import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 01.05.2016.
 */
public class Collections {
  public static void main (String[] args){
    String [] langs = {"Java","C#", "Pyton", "PHP"};

    List<String> languages = Arrays.asList("Java","C#", "Pyton", "PHP");

    for (String l:langs) {
      System.out.println("Я хочу выучить" + l);
    }
  }   
}