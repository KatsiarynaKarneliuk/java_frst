package ru.stqa.frst.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {

    gotoAddNewContactPage();
    fillAddNewContactForm(new ContactData("test1", "test2", "test3", "test1.test2@com", "265-45-89", "852-74-89"));
    submitAddNewContact();
    returntoHome();

  }
}
