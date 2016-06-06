package ru.stqa.frst.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.frst.mantis.model.UserData;

/**
 * Created by user on 02.06.2016.
 */
public class UsersHelper extends HelperBase {

  public Object modifiedUser;

  public UsersHelper(ApplicationManager app) {
    super(app);
  }

  public void initManageUsers() {
    wd.findElement(By.cssSelector("a[href='mantisbt-1.2.19/manage_user_page.php']")).click();
  }

  public void initResetPassword() {
    click(By.cssSelector("input[value = 'Reset Password']"));
  }


  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void setNewPassword(String confirmationLink, String new_password) {
    wd.get(confirmationLink);
    type(By.name("password"),new_password);
    type(By.name("password_confirm"), new_password);
    click(By.cssSelector("input[value = 'Update User']"));
  }
  }

