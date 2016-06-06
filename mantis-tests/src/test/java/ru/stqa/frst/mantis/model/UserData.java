package ru.stqa.frst.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Column(name = "username")
  private String username;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String new_password;

  public String getName() {
    return username;
  }

  public String getNew_password() {
    return new_password;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public int getId() {
    return id;
  }


  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withName(String username) {
    this.username = username;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withNew_password(String new_password) {
    this.new_password = new_password;
    return this;
  }


}
