package ru.stqa.frst.mantis.tests;
import org.testng.annotations.Test;
/**
 * Created by user on 29.05.2016.
 */
public class RegistrationTests extends TestBase {

@Test
  public void testRegistration() {
    app.registration().start("user1", "user1@localhost.localdomain");
  }
}
