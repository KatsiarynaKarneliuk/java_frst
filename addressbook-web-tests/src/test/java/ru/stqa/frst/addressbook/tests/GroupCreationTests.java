package ru.stqa.frst.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("tset3", "test2", "test1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
