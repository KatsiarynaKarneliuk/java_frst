package ru.stqa.frst.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.frst.mantis.appmanager.HttpSession;
import ru.stqa.frst.mantis.model.MailMessage;
import ru.stqa.frst.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 02.06.2016.
 */
public class ResetPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testResertPassword() throws IOException, MessagingException {
    /*String adminLogin = "administrator";
    String adminPassword = "root";
    String email = "email";*/

    String new_password = "new_password";
    UserData userWithNewPassword = app.db().users().stream().filter((u) -> !u.getName()
            .equals("Administrator")).iterator().next();
    app.user().login("administrator", "root");
    assertTrue(app.newSession().login("administrator", "root"));
    app.user().ResetPassword(userWithNewPassword);
    app.user().logout();
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, "email");
    app.user().setNewPassword(confirmationLink, new_password);
    HttpSession session = app.newSession();
    assertTrue(session.login(userWithNewPassword.getName(), new_password));
    assertTrue(session.isLoggedInAs(userWithNewPassword.getUsername()));
    app.user().logout();
  }

  private String findConfirmationLink(List<MailMessage> mailMesages, String email) {
    MailMessage mailMessage = mailMesages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}

