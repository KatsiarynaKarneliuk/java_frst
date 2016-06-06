package ru.stqa.frst.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.frst.mantis.model.UserData;

/**
 * Created by user on 02.06.2016.
 */
public class UserHelper extends HelperBase {


  public UserHelper(ApplicationManager app) {
    super(app);
  }


  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void setNewPassword(String confirmationLink, String new_password) {
    wd.get(confirmationLink);
    type(By.name("password"), new_password);
    type(By.name("password_confirm"), new_password);
    click(By.cssSelector("input[value = 'Update User']"));
  }

  public void logout() {
    click(By.linkText("Logout"));
  }

  public void ResetPassword(UserData user) {
    click(By.linkText("Manage"));
    click(By.linkText("Manage Users"));
    click(By.linkText(user.getName()));
    click(By.cssSelector("input[value='Reset Password']"));
  }
}