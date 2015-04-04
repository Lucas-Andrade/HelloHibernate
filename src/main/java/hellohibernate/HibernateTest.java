package hellohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails(1, "cenas");
		
		Address add1 = new Address();
		Address add2 = new Address();
		
		add1.setCity("city1");
		add1.setPostalCode("pos1");
		add1.setStreet("street1");
		
		add2.setCity("city2");
		add2.setPostalCode("pos2");
		add2.setStreet("street2");
		
		user.getListOfAddresses().add(add1);
		user.getListOfAddresses().add(add2);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName("carrito");
		
		SessionFactory sessionFact = createSessionFactory();
		Session session = sessionFact.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		
		session.close();//de preferencia num bloco finally
		
		//agora vamos buscar um objecto
		
		session = sessionFact.openSession();
		session.beginTransaction();
		UserDetails theSameUser = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("o nome do user tirado da base de dados é " + theSameUser.getUserName());
		session.close();
	}

	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    return configuration.buildSessionFactory(serviceRegistry);
	}
}
