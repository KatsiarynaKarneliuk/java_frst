package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

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
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before -1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "test1.test2@com", "265-45-89", "852-74-89", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returntoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);

  }
}

