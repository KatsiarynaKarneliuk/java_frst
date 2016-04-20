package ru.stqa.frst.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 19.04.2016.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  private  ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper ;



  public void init() {
     wd = new FirefoxDriver();
     wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
     wd.get("http://localhost:8080/dashboard/");
     wd.get("http://localhost:8080/addressbook/");
     contactHelper = new ContactHelper(wd);
     groupHelper = new GroupHelper(wd);
     navigationHelper = new NavigationHelper(contactHelper.wd);
     sessionHelper = new SessionHelper(contactHelper.wd);
     sessionHelper.login("admin", "secret");

  }

  public void stop() {
    wd.quit();
  }
  public void gotoAddNewContactPage() {
    navigationHelper.gotoAddNewContactPage();
  }

  public void gotoGroupPage() {
    navigationHelper.gotoGroupPage();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }




  public ContactHelper getContactHelper() {
    return contactHelper;
  }


  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
