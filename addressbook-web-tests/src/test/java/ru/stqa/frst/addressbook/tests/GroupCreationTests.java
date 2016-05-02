package ru.stqa.frst.addressbook.tests;

        import org.testng.Assert;
        import org.testng.annotations.Test;
        import ru.stqa.frst.addressbook.model.GroupData;

        import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test

  public void testGroupCreation() {

    app.gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", null,null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
