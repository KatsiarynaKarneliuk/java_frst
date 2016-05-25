package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 12.05.2016.
 */
public class ContactDetailsTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().openHomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withName("Иван").withLastname("Иванович").withAddress("Гродно, Гродненская 5, 3")
              .withEmail("test1.test2@com")/*.withEmail2("test1.test5@com").withEmail3("test1.test10@com")*/.withHomephone("2654589")
              .withMobile("8527489").withWorkphone("1234578").withGroup("test1"), true);
    }

  }

  @Test
  public void testContactDetails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactViewForm = app.contact().infoFromViewForm(contact);
    assertThat(contactViewForm.getContent(), equalTo(mergeContentEdit(contactEditForm)));
  }


  private String mergeContentEdit(ContactData contact) {
    return Arrays.asList((contact.getName() + " " + contact.getLastname()), contact.getAddress() + '\n' + '\n' +
                    ("H:" + " " + contact.getHomephone()), ("M:" + " " + contact.getMobile()),
            ("W:" + " " + contact.getWorkphone()) + '\n' + '\n'
                    + contact.getEmail() + " (" + contact.getEmail().replaceAll(contact.getEmail()
                    .split("@")[0] + "@", "www.") + ")", contact.getEmail2(),
            contact.getEmail3() + " (" + contact.getEmail3().replaceAll(contact.getEmail3().split("@")[0] + "@", "www.")
                    + ")").stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

}











