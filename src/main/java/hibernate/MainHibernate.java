package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Hello Hibernate!!!!!!");
		
		
		//configure 
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//sessionfactory is thread safe object ( one object for application)
		//works like connection in jdbc
		SessionFactory factory = cfg.buildSessionFactory();
		
		System.out.println(factory);
		System.out.println(factory.isClosed());
		System.out.println(cfg);
		
		// creating Student-insert into table in database
		
		 Student s=new Student();
         s.setId(1);
         s.setName("Dimpal");
         s.setNum(257421);
         System.out.println(s);//print Student object
         
         // give object to session for save data of object..
         Session session=factory.openSession();
         session.save(s);
         session.getTransaction();
         
          //Starts Transaction and commit it to database
         Transaction tx = session.beginTransaction();
         tx.commit();
         
		
		System.out.println("Successfully saved");
		session.close();
		factory.close();
		
	}

}
