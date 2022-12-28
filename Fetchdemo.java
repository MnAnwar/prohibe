package hibe.prohibe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetchdemo {

	public static void main(String[] args) {
		
		 Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	      
			SessionFactory factory=cfg.buildSessionFactory();
	        
			Session session=factory.openSession();
			student stud=(student)session.get(student.class,101);
			System.out.println(stud);
			
			Addres ad=(Addres)session.get(Addres.class, 1);
			System.out.println(ad.getStreet()+":"+ad.getCity());
			session.close();
			factory.close();   
			

	}

}
