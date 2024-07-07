package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="flightNum-id")
    @OrderColumn(name="sequence")
    private List<Flight> flights = new ArrayList<>();

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }

    public Passenger() {
    }

    public Passenger(String name, Flight flight) {
        this.name = name;
        flights.add(flight);
    }

    public void setFlights(Flight flights) {
        this.flights.add(flights);
    }
}
