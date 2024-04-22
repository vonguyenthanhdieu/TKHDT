package Lab2;

import java.util.List;

public abstract class Customer {
	String name;
	String address;
	List<Reading> readings;
	public Customer(String name, String address, List<Reading> readings) {
		this.name = name;
		this.address = address;
		this.readings = readings;
	}
}
