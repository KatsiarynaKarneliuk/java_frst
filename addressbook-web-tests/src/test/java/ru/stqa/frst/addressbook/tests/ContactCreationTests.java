package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.openHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withName("test1").withLastname("test2").withAddress(null).withEmail("test1.test2@com").withHomephone("265-45-89").withMobile("852-74-89").withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
