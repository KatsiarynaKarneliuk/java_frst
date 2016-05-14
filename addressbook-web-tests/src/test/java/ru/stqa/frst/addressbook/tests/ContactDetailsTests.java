package ru.stqa.frst.addressbook.tests;

import com.sun.jndi.cosnaming.IiopUrl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.sun.xml.internal.ws.encoding.policy.FastInfosetFeatureConfigurator.enabled;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.stqa.frst.addressbook.tests.TestBase.app;

/**
 * Created by user on 12.05.2016.
 */
public class ContactDetailsTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().openHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Иван").withLastname("Иванович").withAddress("Гродно, Гродненская 5, 3")
              .withEmail("test1.test2@com").withEmail2("test1.test5@com").withEmail3("test1.test10@com").withHomephone("2654589")
              .withMobile("8527489").withWorkphone("1234578").withGroup("test1"), true);
    }

  }

  @Test
  public void testContactDetails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactEditForm = app.contact().infoFromEditForm(contact);

    ContactData contactViewForm = app.contact().infoFromViewForm(contact);

    assertThat(contact.getContent() , equalTo(mergeContent(contactEditForm)));
  }
  private String mergeContent(ContactData contact){

    String str = contact.getName() + '\n' + contact.getLastname() + '\n' + contact.getHomephone() + '\n' + contact.getMobile() + '\n'
              + contact.getWorkphone() + '\n' + contact.getAddress() + '\n' + contact.getEmail() + '\n' + contact.getEmail2() + '\n'
              + contact.getEmail3().stream().filter((s) -> !s.equals("")).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
      return str;
    }


  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
  
}








