package hellohibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int VehicleId;
	private String name;
	
	public int getId() {
		return VehicleId;
	}
	public void setId(int id) {
		this.VehicleId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
