package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;
import ru.stqa.frst.addressbook.model.Contacts;
import ru.stqa.frst.addressbook.model.GroupData;
import ru.stqa.frst.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.stqa.frst.addressbook.tests.TestBase.app;

/**
 * Created by user on 25.05.2016.
 */

public class AddContactToGroup  extends TestBase {

@BeforeMethod
public void ensurePreconditions() {
  app.goTo().groupPage();
  if (app.db().groups().size() == 0) {
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("test1"));
  }
}
@Test
  public void testAddContactToGroup(ContactData contact) {
  Groups groups = app.db().groups();
  Contacts before = app.db().contacts();
  File photo = new File("src/test/resources/sost.pereh.png");
  ContactData newContact = new ContactData()/*.withName("test_tname")
            .withLastname("test_surname").withPhoto(photo)*/.inGroup(groups.iterator().next());
  app.goTo().contactPage();
  app.contact().create(newContact, true);
  assertThat(app.contact().count(), equalTo(before.size() + 1));
  Contacts after = app.db().contacts();

  assertThat(after, equalTo(
          before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

}


}