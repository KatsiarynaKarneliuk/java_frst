
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


public class DeletionContactFromGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.openHomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withName("test1").withLastname("test2")
              .withAddress(null).withEmail("test1.test2@com").withHomephone("265-45-89")
              .withMobile("852-74-89"), true);
    }
  }

  @Test

  public void testContactDeletion() {
    app.openHomePage();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));
  }
}



