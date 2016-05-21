package ru.stqa.frst.addressbook.model;


import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name="addressbook")
@XStreamAlias("contact")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name="id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name="firstname")
  private String name;
  @Expose
  @Column(name="lastname")
  private String lastname;
  @Expose
  @Column(name="address")
  @Type(type= "text")
  private String address;
  @Expose
  @Column(name="email")
  @Type(type= "text")
  private String email;
  @Expose
  @Column(name="email2")
  @Type(type= "text")
  private String email2;
  @Expose
  @Column(name="email3")
  @Type(type= "text")
  private String email3;
  @Expose
  @Column(name="home")
  @Type(type= "text")
  private String homephone;
  @Expose
  @Column(name="mobile")
  @Type(type= "text")
  private String mobile;
  @Expose
  @Column(name="work")
  @Type(type= "text")
  private String work;
  @Expose
  @Transient
  private String allPhones;
  @Expose
  @Transient
  private String allEmails;
  @Transient
  private String content;
  @Column(name="photo")
  @Type(type= "text")
  private String photo;
  @Transient
  private  String group;

  public File getPhoto() {
    return new File (photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


  public ContactData withContent(String content) {
    this.content = content;
    return this;
  }




  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobile(String mobile) {

    this.mobile = mobile;
    return this;
  }

  public ContactData withWorkphone(String work) {
    this.work = work;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public String getContent() {
    return content;
  }

  public int getId() {
    return id;
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

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getWorkphone() {
    return work;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobile() {
    return mobile;
  }

  public String getGroup() {
    return group;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getAllPhones() {
    return allPhones;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


}
