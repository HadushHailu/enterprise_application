package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
    public List<Customer> findAll();
    public List<Customer> findByAddressZip(String zip);
    public List<Customer> findByTheOrdersOrderlinesProductName(String name);

    public List<Customer> findCountry(@Param("country") String country);

    @Query("SELECT c FROM Customer c JOIN c.theOrders o WHERE o.status =:status")
    public List<String> findOrderNumClosed(@Param("status") String status);

    @Query("SELECT c.firstname, c.lastname FROM Customer c WHERE c.address.city = 'Amsterdam'")
    public List<String[]> findCustomersInAmsterdam();

    @Query("SELECT o.ordernr FROM Customer c JOIN c.theOrders o WHERE c.address.city = :city")
    List<String> findOrderNumbersByCity(@Param("city") String city);
}
