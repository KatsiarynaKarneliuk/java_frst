package ru.stqa.frst.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 19.04.2016.
 */
public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super (wd);
  }

  public void gotoGroupPage() {
      click(By.linkText("groups"));

  }
  public void gotoAddNewContactPage() {
    click(By.linkText("add new"));
  }
}
