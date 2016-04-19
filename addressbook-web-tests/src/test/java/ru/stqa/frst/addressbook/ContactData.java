package ru.stqa.frst.addressbook;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String address;
  private final String email;
  private final String homephone;
  private final String mobile;

  public ContactData(String name, String lastname, String address, String email, String homephone, String mobile) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.email = email;
    this.homephone = homephone;
    this.mobile = mobile;
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
}
