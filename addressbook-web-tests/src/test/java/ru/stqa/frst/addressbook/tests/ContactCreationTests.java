package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;
import ru.stqa.frst.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.openHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("test1").withLastname("test2").withAddress(null).withEmail("test1.test2@com").withHomephone("265-45-89").withMobile("852-74-89").withGroup("test1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
