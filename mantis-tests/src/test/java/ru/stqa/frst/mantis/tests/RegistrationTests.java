package ru.stqa.frst.mantis.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.frst.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 29.05.2016.
 */
public class RegistrationTests extends TestBase {
@BeforeMethod
public void startMailServer(){
  app.mail().start();
}
@Test
  public void testRegistration() throws IOException, MessagingException {
  String email = "user1@localhost.localdomain";
  String user = "user1";
  app.registration().start(user, email);
  List<MailMessage> mailMessages = app.mail().waitForMail(2,10000);
 String confirmationLink  = findConfirmationLink(mailMessages, email);
  String password = "password";
  app.registration().finish(confirmationLink,password);
  assertTrue(app.newSession().login(user,password));
  }

  private String findConfirmationLink(List<MailMessage> mailMesages, String email) {
    MailMessage mailMessage=mailMesages.stream().filter((m)->m.to.equals(email)).findFirst().get();
VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
   return regex.getText(mailMessage.text);
  }


  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}
