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


/**
 * Created by user on 25.05.2016.
 */

public class AddContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
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
    ContactData newContact = new ContactData().withName("test_name")
            .withLastname("test_surname").withPhoto(photo).inGroup(groups.iterator().next());
    app.goTo().openHomePage();
    app.contact().create(contact, true);
    app.contact().selectContactById(newContact.getId());
    GroupData freeGroup = app.db().groups().iterator().next();
    app.contact().selectGroup(freeGroup);
    app.contact().submitAddToGroup();
    app.goTo().openHomePage();

    assertThat(app.contact().isContactInGroup(newContact, freeGroup), equalTo(true));
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyContactpListInUI();

  }
}




