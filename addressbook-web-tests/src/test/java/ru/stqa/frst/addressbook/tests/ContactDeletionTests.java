package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;
import java.util.Set;

/**
 * Created by user on 22.04.2016.
 */
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.openHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("test1").withLastname("test2").withAddress(null).withEmail("test1.test2@com").withHomephone("265-45-89").withMobile("852-74-89").withGroup("test1"), true);
    }
  }

  @Test

  public void testContactDeletion() {
    app.openHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);

    Assert.assertEquals(before, after);
  }


}
