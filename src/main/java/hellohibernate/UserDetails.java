package hellohibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Hello world!
 *
 */
@Entity
public class UserDetails 
{
	
	@Id
	private int userID;
	private String userName;
	
	@ElementCollection
	private Set<Address> listOfAddresses = new HashSet<Address>();
	
	@OneToOne
	private Vehicle vehicle;
	
	@OneToMany
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public UserDetails() {}
	
	public UserDetails(int id, String name) {
		userID = id;
		userName = name;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
}
