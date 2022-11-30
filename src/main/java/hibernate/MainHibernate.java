package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainHibernate {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello Hibernate!!!!!!");

		// configure
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		// sessionfactory is thread safe object ( one object for application)
		// works like connection in jdbc
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(factory);
		System.out.println(factory.isClosed());
		System.out.println(cfg);

		// creating Student-insert into table in database

		Student2 s = new Student2();
		s.setId(1);
		s.setName("Dimpal");
		s.setNum(257421);

		
		// give object to session for save data of object..
		Session session = factory.openSession();
		session.save(s);
		session.beginTransaction();
		Query<Student2> q1 = session.createQuery("from Student2 where id=1");
		q1.setCacheable(true);
		Student2 ss = (Student2) q1.uniqueResult();
		System.out.println(ss);

		Student2 s1 = (Student2) session.get(Student2.class, 1);
		System.out.println(s1);
		session.getTransaction().commit();
		session.close();

		Session session1 = factory.openSession();
		session1.beginTransaction();
		Query<Student2> q2 = session1.createQuery("from Student2 where id=1");
		q2.setCacheable(true);
		Student2 ss1 = (Student2) q2.uniqueResult();

		System.out.println(ss1);
		Student2 s2 = (Student2) session1.get(Student2.class, 1);
		System.out.println(s2);
		session1.getTransaction().commit();

		session1.close();
		factory.close();

	}

}
