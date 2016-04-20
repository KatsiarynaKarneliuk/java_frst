package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.gotoAddNewContactPage();
    app.getContactHelper().fillAddNewContactForm(new ContactData("test1", "test2", "test3", "test1.test2@com", "265-45-89", "852-74-89"));
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returntoHome();

  }
}
