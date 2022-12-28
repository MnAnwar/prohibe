package hibe.prohibe;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;



import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )throws  IOException
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
      
		SessionFactory factory=cfg.buildSessionFactory();
        
		
		
		Addres ad=new Addres();
		
		ad.setStreet("street");
		ad.setCity("patna");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(213.34);
		//Uploading image
		FileInputStream fis=new FileInputStream("src/main/java/anwar.jpg");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		//creating student objects
		student st=new student();
		st.setId(101);
		st.setName("JHON");
		st.setCity("PATNA");
		System.out.println(st);
		
		Session session=factory.openSession();
		
		///
		
		Transaction tx= session.beginTransaction();
		 session.save(st);
		 session.save(ad);
		 tx.commit();	
		
		session.close();
		System.out.println("kam pura ho gailas");
    }
    
}
