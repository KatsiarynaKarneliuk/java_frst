package ru.stqa.frst.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String address;
  private final String email;
  private final String homephone;
  private final String mobile;
  private static String group;

  public ContactData(String name, String lastname, String address, String email, String homephone, String mobile, String Group) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.email = email;
    this.homephone = homephone;
    this.mobile = mobile;
    group = Group;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobile() {
    return mobile;
  }

  public static String getGroup() {
    return group;
  }
}
