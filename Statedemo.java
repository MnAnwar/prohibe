package hibe.prohibe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Statedemo {

	public static void main(String[] args) {
		
		System.out.println("Example");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		
		student stud=new student();
		stud.setId(1441);
		stud.setId(1442);

		stud.setName("nehal");
		stud.setName("kamal");
		stud.setCity("patna");
		stud.setCity("mfp");
		stud.setCerti(new Certificate("java hibernate Course","2 month"));
		stud.setCerti(new Certificate("java spring boot Course","2 month"));
		
		student stud1=new student();
		
		stud1.setId(1443);

	
		stud1.setName("kamal");
		stud1.setCity("patna");
		
		stud1.setCerti(new Certificate("java hibernate Course","2 month"));
		
		
		student stud2=new student();
		
		stud2.setId(1243);

	
		stud2.setName("kamala");
		stud2.setCity("patnr");
		
		stud2.setCerti(new Certificate("java jbosss tools Course","2 month"));
		
		
		//student: Transient
		
		
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(stud);
		s.save(stud1);
		s.save(stud2);
		// student: Persistent  - session, database
		
		stud.setName("Anwar");
		
		tx.commit();
		
		//fetch data 
		/*student st= (student)s.get(student.class , 1441);
		System.out.println(st.getCerti());
		System.out.println(st.getName());*/
		
				
		s.close();
		
		//student : Detached
		
		/*stud.setName("kamal");
		System.out.println(stud);
		f.close();*/

	}

}
