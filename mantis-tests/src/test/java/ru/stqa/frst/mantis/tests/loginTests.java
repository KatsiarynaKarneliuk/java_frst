package ru.stqa.frst.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


/**
 * Created by user on 29.05.2016.
 */
public class loginTests extends TestBase {

  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
