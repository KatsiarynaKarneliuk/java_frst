package ru.stqa.frst.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.frst.addressbook.model.GroupData;
import ru.stqa.frst.addressbook.model.Groups;

import static org.testng.Assert.assertEquals;

/**
 * Created by user on 20.04.2016.
 */
public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {

    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(before.size(), after.size());

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
  }
}

