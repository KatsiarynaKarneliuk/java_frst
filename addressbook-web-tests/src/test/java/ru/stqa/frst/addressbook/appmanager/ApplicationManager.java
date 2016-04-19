package ru.stqa.frst.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 19.04.2016.
 */
public class ApplicationManager {
  FirefoxDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper ;

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      }   catch (NoAlertPresentException e) {
          return false;
      }
  }

  public void init() {
     wd = new FirefoxDriver();
     wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     wd.get("http://localhost:8080/dashboard/");
     wd.get("http://localhost:8080/addressbook/");
     groupHelper = new GroupHelper(wd);
     navigationHelper = new NavigationHelper(wd);
     sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }



  public void returntoHome() {
   wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
  }

  public void submitAddNewContact() {
   wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillAddNewContactForm(ContactData addNewContactData) {
    navigationHelper.wd.findElement(By.name("firstname")).click();
    navigationHelper.wd.findElement(By.name("firstname")).clear();
    navigationHelper.wd.findElement(By.name("firstname")).sendKeys(addNewContactData.getName());
    navigationHelper.wd.findElement(By.name("lastname")).click();
    navigationHelper.wd.findElement(By.name("lastname")).clear();
    navigationHelper.wd.findElement(By.name("lastname")).sendKeys(addNewContactData.getLastname());
    navigationHelper.wd.findElement(By.name("address")).click();
    navigationHelper.wd.findElement(By.name("address")).clear();
    navigationHelper.wd.findElement(By.name("address")).sendKeys(addNewContactData.getAddress());
    navigationHelper.wd.findElement(By.name("home")).click();
    navigationHelper.wd.findElement(By.name("email")).click();
    navigationHelper.wd.findElement(By.name("email")).clear();
    navigationHelper.wd.findElement(By.name("email")).sendKeys(addNewContactData.getEmail());
    navigationHelper.wd.findElement(By.name("theform")).click();
    navigationHelper.wd.findElement(By.name("home")).click();
    navigationHelper.wd.findElement(By.name("home")).clear();
    navigationHelper.wd.findElement(By.name("home")).sendKeys(addNewContactData.getHomephone());
    navigationHelper.wd.findElement(By.name("mobile")).click();
    navigationHelper.wd.findElement(By.name("mobile")).clear();
    navigationHelper.wd.findElement(By.name("mobile")).sendKeys(addNewContactData.getMobile());
  }

  public void gotoAddNewContactPage() {
    navigationHelper.wd.findElement(By.linkText("add new")).click();
  }

  public void stop() {
    navigationHelper.wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void gotoGroupPage() {
    navigationHelper.gotoGroupPage();
  }
}
