package ru.stqa.frst.addressbook.model;

public class GroupData {
  private final String id;
  private final String footer;
  private final String header;
  private final String name;

  public String getId() {
    return id;
  }


  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != null ? !id.equals(groupData.id) : groupData.id != null) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
  public GroupData(String name, String header, String footer) {
    this.id = null;
    this.footer = footer;
    this.header = header;
    this.name = name;
  }

  public GroupData(String id, String name, String header, String footer) {
    this.id = id;
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
