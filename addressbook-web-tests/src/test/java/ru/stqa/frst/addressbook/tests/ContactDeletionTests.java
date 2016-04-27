package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

/**
 * Created by user on 22.04.2016.
 */
public class ContactDeletionTests extends TestBase{
  @Test

public void testContactDeletion() {
    app.openHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returntoHome();
  }

}
