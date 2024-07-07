package repositories;

import domain.Customer;
import domain.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DVDRepository extends JpaRepository<DVD, Long> {
    public List<Customer> findByName(String genre);
}
