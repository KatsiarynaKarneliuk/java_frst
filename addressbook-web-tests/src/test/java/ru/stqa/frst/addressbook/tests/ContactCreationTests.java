package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.openHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", null, "test1.test2@com", "265-45-89", "852-74-89","test1"), true);
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returntoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before +1);
  }
}
