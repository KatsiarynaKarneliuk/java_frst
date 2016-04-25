package ru.stqa.frst.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.frst.addressbook.model.ContactData;

/**
 * Created by user on 20.04.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returntoHome() {
    wd.findElement(By.linkText("home"));
  }

  public void submitAddNewContact() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData addNewContactData) {
    wd.findElement(By.name("firstname")).click();

    type(By.name("firstname"), addNewContactData.getName());
    wd.findElement(By.name("lastname")).click();

    type(By.name("lastname"), addNewContactData.getLastname());
    wd.findElement(By.name("address")).click();

    type(By.name("address"), addNewContactData.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("email")).click();

    type(By.name("email"), addNewContactData.getEmail());
    wd.findElement(By.name("home")).click();

    type(By.name("home"), addNewContactData.getHomephone());
    wd.findElement(By.name("mobile")).click();

    type(By.name("mobile"), addNewContactData.getMobile());
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//tr[@class='odd']/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void submitContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void openHomePage() {
    click(By.linkText("home"));
  }
}