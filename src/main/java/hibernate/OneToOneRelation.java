package hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneRelation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Hello Hibernate!!!!!!");

		SessionFactory factory = new Configuration().configure("onetoone.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

//		System.out.println(factory);
//		System.out.println(factory.isClosed());

		// creating object of Student

		Student s = new Student();
		s.setName("Neha");
		s.setNum(257421);

		// creating object of StudentAddress
		StudentAddress sa = new StudentAddress();
		sa.setHouseNo(264);
		sa.setStreetName("Weber Street");
		sa.setPincode("I8S 6R3");
		sa.setDate(new Date());

		// set image
		FileInputStream f = new FileInputStream("src/main/java/1.jpg.png");
		byte[] data = new byte[f.available()];
		f.read();
		sa.setImage(data);
		sa.setStudent(s);

		s.setStudentAddress(sa);
		session.save(s);

		session.getTransaction();
		tx.commit();

		// get data from table
		// get - student:2(id)

		StudentAddress s1 = session.get(StudentAddress.class, 2);
		System.out.println(s1);

		System.out.println("Successfully saved");
		session.close();
		factory.close();
		f.close();
	}

}
