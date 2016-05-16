package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.ContactData;
import ru.stqa.frst.addressbook.model.Contacts;
import ru.stqa.frst.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
@DataProvider
public Iterator<Object[]> validGroups() throws IOException {
  List<Object[]> list = new ArrayList<Object[]>();
  BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
  String line = reader.readLine();
  while (line != null) {
    String[] split = line.split(";");
    list.add(new Object[]{new ContactData().withName(split[0]).withLastname(split[1]).withAddress(split[2])
            .withEmail(split[3]).withEmail2(split[4]).withEmail3(split[5]).withHomephone(split[6]).withMobile(split[7]).withWorkphone(split[8]).withGroup(split[8])});
    line = reader.readLine();
  }
  return list.iterator();
}
  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.openHomePage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
