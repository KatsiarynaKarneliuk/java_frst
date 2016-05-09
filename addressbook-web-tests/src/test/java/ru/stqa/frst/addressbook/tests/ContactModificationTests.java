package ru.stqa.frst.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 22.04.2016.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.openHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("test1").withLastname("test2"). withAddress(null).withEmail("test1.test2@com"). withHomephone("265-45-89").withMobile("852-74-89").withGroup("test1"), true);
    }
  }
  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withName("test1").withLastname("test2"). withAddress(null).withEmail("test1.test2@com"). withHomephone("265-45-89").withMobile("852-74-89").withGroup(null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1,c2)-> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

  }


