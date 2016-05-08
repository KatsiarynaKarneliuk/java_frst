package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by user on 22.04.2016.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePerconditions(){
    app.openHomePage();
    if (!app.getContactHelper().isThereAContactData()) {
      app.getContactHelper().createContact(new ContactData("test1", "test2", null, "test1.test2@com", "265-45-89", "852-74-89", "test1"), true);
    }
  }
  @Test

  public void testContactDeletion() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returntoHome();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);

    Assert.assertEquals(before, after);
  }
}
