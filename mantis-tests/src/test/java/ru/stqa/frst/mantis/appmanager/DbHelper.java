package ru.stqa.frst.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.frst.mantis.model.UserData;
import ru.stqa.frst.mantis.model.Users;

import java.util.List;

/**
 * Created by user on 03.06.2016.
 */
public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper() {

    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Users users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData where username !=admin").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }


}


