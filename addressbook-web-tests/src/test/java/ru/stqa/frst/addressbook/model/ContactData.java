package ru.stqa.frst.addressbook.model;


public class ContactData {
  private int id;
  private final String name;
  private final String lastname;
  private final String address;
  private final String email;
  private final String homephone;
  private final String mobile;
  private static String group;

  public int getId() {
    return id;
  }


  public ContactData(String name, String lastname, String address, String email, String homephone, String mobile, String Group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.lastname = lastname;

    this.address = address;
    this.email = email;
    this.homephone = homephone;
    this.mobile = mobile;

    group = Group;
  }

  public ContactData(int id, String name, String lastname, String address, String email, String homephone, String mobile, String Group) {
    this.id = id;
    this.name = name;

    this.lastname = lastname;

    this.address = address;
    this.email = email;
    this.homephone = homephone;
    this.mobile = mobile;
    group = Group;
  }

  public void setId(int max) {
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
