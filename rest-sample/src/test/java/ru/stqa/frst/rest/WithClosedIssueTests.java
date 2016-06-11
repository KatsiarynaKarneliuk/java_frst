package ru.stqa.frst.rest;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by user on 11.06.2016.
 */
public class WithClosedIssueTests extends TestBase{
  @Test
  public void testWithClosedIssue()throws IOException {
    skipIfNotFixed(19);
  }
}
