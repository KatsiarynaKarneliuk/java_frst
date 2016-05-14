package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;
import ru.stqa.frst.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.openHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/sost.pereh.png");
    ContactData contact = new ContactData().withName("test1").withLastname("test2").withAddress("Петербург")
            .withEmail("test1.test2@com").withEmail2("test1.test5@com").withEmail3("test1.test10@com").withHomephone("2654589")
            .withMobile("8527489").withWorkphone("1234578").withPhoto(photo).withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
