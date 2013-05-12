package pack;

import org.hibernate.impl.SessionFactoryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Example for a class that can be used by
 * SQuirreLSQL's Hibernate Plugin to provide
 * a Hibernate SessionFactoryImpl object.
 *
 */
public class ExampleSessionFactorImplProvider
{
   /**
    * The SessionFactorImpl provider class must have a method
    * with exactly this signature and name.
    */
   public SessionFactoryImpl getSessionFactoryImpl()
   {
      // Normally you can cast this object to org.hibernate.impl.SessionFactoryImpl as shown below.  
      SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

      return (SessionFactoryImpl) sessionFactory;
   }

}
