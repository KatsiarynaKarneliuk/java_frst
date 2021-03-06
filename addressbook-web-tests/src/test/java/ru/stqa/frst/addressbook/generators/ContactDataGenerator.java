package ru.stqa.frst.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
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
  @Parameter(names = "-c", description = "Contact count")
  public int count;


  @Parameter(names = "-f", description = "Target file")
  public String file;


  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if(format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    }else if(format.equals("xml")){
      saveAsXml(contacts, new File (file));
    }else if(format.equals("json")){
      saveAsJson(contacts, new File (file));
    }else{
      System.out.println("unrecognized format" + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson= new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try(Writer writer = new FileWriter (file);){
    writer.write(json);}
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML (contacts);
    try(Writer writer = new FileWriter(file);){
    writer.write(xml);}
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withName(String.format("Иван %s", i)).withLastname(String.format("Иванов %s", i))
              .withAddress(String.format("Петербург %s", i)).withEmail(String.format("test1.test2@com %s", i))
             .withEmail2(String.format("test1.test5@com %s", i)).withEmail3(String.format("test1.test10@com %s", i))
              .withHomephone(String.format("2654585 %s", i)).withMobile(String.format("8527485 %s", i))
              .withWorkphone(String.format("1234575 %s", i)));
    }
    return contacts;
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try(Writer writer = new FileWriter(file);){
    for (ContactData contact : contacts) {
    writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", contact.getName(), contact.getLastname(), contact.getAddress()
              , contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getHomephone(), contact.getMobile()
              , contact.getWorkphone()));}
    }
  }
}
