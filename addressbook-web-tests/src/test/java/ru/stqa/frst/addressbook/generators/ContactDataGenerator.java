package ru.stqa.frst.addressbook.generators;

import ru.stqa.frst.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15.05.2016.
 */
public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withName(String.format("Иванов %s", i)).withLastname(String.format("test2 %s", i))
              .withAddress(String.format("Петербург %s", i)).withEmail(String.format("test1.test2@com %s", i))
              .withEmail2(String.format("test1.test5@com %s", i)).withEmail3(String.format("test1.test10@com %s", i))
              .withHomephone(String.format("2654585 %s", i)).withMobile(String.format("8527485 %s", i))
              .withWorkphone(String.format("1234575 %s", i)).withGroup(String.format("test1 %s", i)));
    }
    return contacts;
  }


  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;\n", contact.getName(), contact.getLastname(), contact.getAddress()
              , contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getHomephone(), contact.getMobile()
              , contact.getWorkphone(), contact.getGroup()));

    }
writer.close();
  }

}
