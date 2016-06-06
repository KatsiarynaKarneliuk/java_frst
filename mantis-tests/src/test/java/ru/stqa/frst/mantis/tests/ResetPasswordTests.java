package ru.stqa.frst.mantis.tests;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.frst.mantis.model.MailMessage;
import
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 02.06.2016.
 */
public class ResetPasswordTests extends TestBase {

  @BeforeClass
  public void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testResertPassword() throws IOException, MessagingException {
    String adminLogin = "administrator";
    String adminPassword = "root";
    String user = "user1";
    String password = "123";
    String email = "user1@localhost.localdomain";
    String new_password = "1234";

    app.UsersHelper().login(adminLogin, adminPassword);
    app.UsersHelper().initManageUsers();
    app.UsersHelper().modifiedUser = app.db().users().stream().filter((u)->!u.getName().equals("Administrator")).iterrator().next();
    app.UsersHelper().initResetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.UsersHelper().setNewPassword(confirmationLink,new_password);
    assertTrue(app.newSession().login(user, new_password));
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

