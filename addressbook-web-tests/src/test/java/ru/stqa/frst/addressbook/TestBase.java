package ru.stqa.frst.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 18.04.2016.
 */
public class TestBase {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
  }

  @BeforeMethod
  public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost:8080/dashboard/");
      wd.get("http://localhost:8080/addressbook/");
      login("admin", "secret");

  }

  protected void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
      wd.findElement(By.xpath("//div[@id='content']/form")).click();
  }

  protected void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  protected void gotoGroupPage() {
      wd.findElement(By.linkText("groups")).click();
  }

  private void login(String username, String password) {
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).sendKeys("\\undefined");
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).sendKeys("\\undefined");
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys();
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys();
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.id("LoginForm")).click();
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  protected void returntoHome() {
    wd.findElement(By.xpath("//div/div[4]/div/i/a[2]")).click();
  }

  protected void submitAddNewContact() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void fillAddNewContactForm(ContactData addNewContactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(addNewContactData.getName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(addNewContactData.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(addNewContactData.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(addNewContactData.getEmail());
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(addNewContactData.getHomephone());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(addNewContactData.getMobile());
  }

  protected void gotoAddNewContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
      wd.quit();
  }

  protected void deleteSelectedGroups() {
      wd.findElement(By.name("delete")).click();
  }

  protected void selectGroup() {
      if (!wd.findElement(By.name("selected[]")).isSelected()) {
          wd.findElement(By.name("selected[]")).click();
      }
  }
}
