package repositories;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select * from address a where a.city='Amsterdam'", nativeQuery = true)
    public List<Address> findAddressInAmsterdam();
}
