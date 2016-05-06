package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

/**
 * Created by user on 22.04.2016.
 */
public class ContactDeletionTests extends TestBase {
  @Test

  public void testContactDeletion() {
    app.openHomePage();
    if (!app.getContactHelper().isThereAContactData()) {
      app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test1.test2@com", "265-45-89", "852-74-89", "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before -1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returntoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before -1);
  }

}
