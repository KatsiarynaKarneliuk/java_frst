package ru.stqa.frst.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20.04.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returntoHome() {
    wd.findElement(By.linkText("home")).click();
  }

  public void submitAddNewContact() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData addNewContactData, boolean creation) {
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

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }
  }

  public void gotoAddNewContactPage() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
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

  public void createContact(ContactData contactData, boolean creation) {
    gotoAddNewContactPage();
    fillContactForm(contactData, creation);
    submitAddNewContact();
    returntoHome();
  }

  public boolean isThereAContactData() {

    return isElementPresent(
            By.name("selected[]"));
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      ContactData contact = new ContactData(firstname, lastname, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}

