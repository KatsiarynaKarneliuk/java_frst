package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 11.05.2016.
 */
public class ContactPhoneTests extends TestBase {
 @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().openHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Иван").withLastname("Иванович").withAddress("Гродно")
              .withEmail("test1.test2@com").withEmail2("test1.test5@com").withEmail3("test1.test10@com").withHomephone("2654589")
              .withMobile("8527489").withWorkphone("1234578").withGroup("test1"), true);
    }
  }
  @Test
  public void testContactPhone(){
    app.goTo().openHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3()).stream().filter((s)->!s.equals("")).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomephone(),contact.getMobile(),contact.getWorkphone()).stream().filter((s)->!s.equals("")).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  }
