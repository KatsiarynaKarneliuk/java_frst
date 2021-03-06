package ru.stqa.frst.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;
import ru.stqa.frst.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by user on 22.04.2016.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.openHomePage();
      app.contact().create(new ContactData().withName("Иван").withLastname("Иванов").withAddress("Москва").withEmail("test1.test2@com").withHomephone("265-45-89").withMobile("852-74-89")/*.withGroup("test1")*/, true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Сидор").withLastname("Сидоров").withAddress("Самара").withEmail("test1.test2@com").withHomephone("265-45-89").withMobile("852-74-89")/*.withGroup(null)*/;
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo (before.size()));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactpListInUI();
  }


}




