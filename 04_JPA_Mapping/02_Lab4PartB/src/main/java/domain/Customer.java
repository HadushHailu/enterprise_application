package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Address address;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private Collection<Order> theOrders = new ArrayList<Order>();

	public Customer() {
	}

	public Customer(String firstname, String lastname, Address address, Order order) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		theOrders.add(order);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", address=" + address +
				", theOrders=" + theOrders +
				'}';
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Collection<Order> getTheOrders() {
		return Collections.unmodifiableCollection(theOrders);
	}

	
	public boolean addOrder(Order order) {
		boolean added = theOrders.add(order); 
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = theOrders.remove(order);
		if (removed) {
			theOrders.remove(order);
		}
		return removed;
	}
}
