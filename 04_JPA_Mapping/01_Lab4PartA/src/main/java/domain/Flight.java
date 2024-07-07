package domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String flightNumber;
    private String departure;
    private String destination;
    @Temporal(TemporalType.DATE)
    private Date date;

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                '}';
    }

    public Flight() {
    }

    public Flight(String flightNumber, String departure, String destination, Date date) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }
}
