package ru.stqa.frst.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test

    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("tset3", "test2", "test1"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
