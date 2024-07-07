package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


@Entity
@Table(name="custOrder")
public class Order {

	@Id
	private String ordernr;
	private Date date;
	private String status;

	@ManyToOne
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernr, Date date, String status, OrderLine orderLine) {
		this.ordernr = ordernr;
		this.date = date;
		this.status = status;
		this.orderlines.add(orderLine);
	}

	@Override
	public String toString() {
		return "Order{" +
				"date=" + date +
				", status='" + status + '\'' +
				", orderlines=" + orderlines +
				'}';
	}

	public String getOrdernr() {
		return ordernr;
	}

	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {

		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

}
