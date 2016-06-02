package ru.stqa.frst.mantis.model;

/**
 * Created by user on 31.05.2016.
 */
public class MailMessage {
  public String to;
  public String text;

  public MailMessage(String to, String text){
    this.to=to;
    this.text=text;
  }
}
