package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.gotoAddNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", null, "test1.test2@com", "265-45-89", "852-74-89"));
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returntoHome();

  }
}
