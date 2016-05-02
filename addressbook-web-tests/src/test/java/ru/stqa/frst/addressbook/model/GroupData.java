package ru.stqa.frst.addressbook.model;

public class GroupData {
  private final String footer;
  private final String header;
  private final String name;

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;

  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  public GroupData(String footer, String header, String name) {
    this.footer = footer;
    this.header = header;
    this.name = name;
  }

  public String getFooter() {
    return footer;
  }

  public String getHeader() {
    return header;
  }

  public String getName() {
    return name;
  }
}
