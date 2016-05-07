package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by user on 22.04.2016.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.openHomePage();
    if (!app.getContactHelper().isThereAContactData()) {
      app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test1.test2@com", "265-45-89", "852-74-89", "test1"), true);
    }
    List<ContactData>before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "test1.test2@com", "265-45-89", "852-74-89", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returntoHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

  }
}

