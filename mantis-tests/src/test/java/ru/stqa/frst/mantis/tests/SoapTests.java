package ru.stqa.frst.mantis.tests;

        import org.testng.annotations.Test;
        import ru.stqa.frst.mantis.model.Issue;
        import ru.stqa.frst.mantis.model.Project;

        import javax.xml.rpc.ServiceException;
        import java.net.MalformedURLException;
        import java.rmi.RemoteException;
        import java.util.Set;

        import static org.testng.Assert.assertEquals;

/**
 * Created by user on 07.06.2016.
 */
public class SoapTests extends TestBase{
  @Test
  public  void testGetProjects() throws RemoteException, MalformedURLException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for(Project project :projects)
      System.out.println(project.getName());

  }
  @Test
  public void testCreateIssue()throws RemoteException, MalformedURLException, ServiceException {
    Set<Project> projects = app.soap().getProjects();
  Issue issue = new Issue().withSummary("Test issue").withDescription("Test issue description")
            .withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());
  }
  @Test
  public void testWithIssue()throws RemoteException, MalformedURLException, ServiceException{
    skipIfNotFixed(	0000002);
  }
}
