package hibe.prohibe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Emdubd {

	public static void main(String[] args) {
		
		 Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	      
			SessionFactory factory=cfg.buildSessionFactory();
			
			student study=new student();
			study.setCity("Patna central");
			study.setId(123);
			study.setName("Anwar");
			
			Certificate as=new Certificate();
			as.setCourse("Androide");
			as.setDuration("1 month");
			study.setCerti(as);
			
			student study1=new student();
			study1.setCity("Chennai central");
			study1.setId(124);
			study1.setName("N Anwar");
			
			Certificate as1=new Certificate();
			as1.setCourse("Etherium");
			as1.setDuration("2 month");
			study1.setCerti(as1);
			
			Session s=factory.openSession();
			Transaction tx=s.beginTransaction();
			
			//save object
			s.save(study);
			s.save(study1);
			
			tx.commit();
			s.close();
			factory.close();
	}

}
