package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class JPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session= factory.openSession();
		
		People p1 = new People();
		p1.setId(1);
		p1.setName("Bhavin");
		p1.setMarks(95);
		
		People p2 = new People();
		p2.setId(2);
		p2.setName("Sandip");
		p2.setMarks(85);
		
		People p3 = new People();
		p3.setId(3);
		p3.setName("Alpesh");
		p3.setMarks(55);
		
		People p4 = new People();
		p4.setId(4);
		p4.setName("Kalindi");
		p4.setMarks(66);
		
		People p5 = new People();
		p5.setId(5);
		p5.setName("Krupa");
		p5.setMarks(75);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		
		Transaction tx = session.beginTransaction();
		tx.commit();
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("pu");
		EntityManager m = emf.createEntityManager();
		People p6 = new People();
		p6.setId(6);
		p6.setName("Karuna");
		p6.setMarks(76);
		
		m.getTransaction().begin();
		m.persist(p6);
//		People p =m.find(People.class,4);
		m.getTransaction().commit();
		System.out.println(p6);
		session.close();
		factory.close();
		
		
	}

}
