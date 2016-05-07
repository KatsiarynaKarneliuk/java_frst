package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.openHomePage();
    List<ContactData>before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", null, "test1.test2@com", "265-45-89", "852-74-89","test1"), true);
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returntoHome();
    List<ContactData>after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() +1);
  }
}
