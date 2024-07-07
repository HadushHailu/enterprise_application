package domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Long id;
	private String appdate;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Patient patient;
	@Embedded
	private Payment payment;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Doctor doctor;

	public Appointment() {
	}

	@Override
	public String toString() {
		return "Appointment{" +
				"appdate='" + appdate + '\'' +
				", patient=" + patient +
				", payment=" + payment +
				", doctor=" + doctor +
				'}';
	}

	public Appointment(String appdate, Patient patient, Payment payment,
					   Doctor doctor) {
		this.appdate = appdate;
		this.patient = patient;
		this.payment = payment;
		this.doctor = doctor;
	}


	public String getAppdate() {
		return appdate;
	}

	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
